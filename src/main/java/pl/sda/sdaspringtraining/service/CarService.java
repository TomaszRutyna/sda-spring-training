package pl.sda.sdaspringtraining.service;

import org.springframework.stereotype.Service;
import pl.sda.sdaspringtraining.api.model.Car;
import pl.sda.sdaspringtraining.api.model.NewCar;
import pl.sda.sdaspringtraining.api.model.UpdateCar;
import pl.sda.sdaspringtraining.domain.CarEntity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {

    private static Integer carId = 0;
    private static List<CarEntity> cars = new ArrayList<>();

    public void createCar(NewCar newCar) {
        cars.add(new CarEntity(carId++, newCar.getRegisterPlate(), newCar.getProducer(),
                newCar.getModel(), newCar.getYearOfProduction(), newCar.getOptions()));
    }

    public void updateCar(UpdateCar updateCar) {
        for (CarEntity entity : cars) {
            if (entity.getId() == updateCar.getId()) {
                entity.setRegisterPlate(updateCar.getRegisterPlate());
                entity.setOptions(updateCar.getOptions());
            }
        }
    }

    public Optional<Car> getById(Integer id) {
        return cars.stream().filter(cus -> cus.getId() == id)
                .findFirst()
                .map(ent -> new Car(ent.getId(), ent.getRegisterPlate(), ent.getProducer(),
                        ent.getModel(), ent.getYearOfProduction(), ent.getOptions()));
    }

    public List<Car> getAll() {
        return cars.stream()
                .map(ent -> new Car(ent.getId(), ent.getRegisterPlate(), ent.getProducer(),
                        ent.getModel(), ent.getYearOfProduction(), ent.getOptions()))
                .collect(Collectors.toList());
    }

    public void deleteById(Integer id) {
        Iterator<CarEntity> carIterator = cars.iterator();
        while (carIterator.hasNext()) {
            CarEntity next = carIterator.next();
            if (next.getId() == id) {
                carIterator.remove();
                return;
            }
        }
    }
}
