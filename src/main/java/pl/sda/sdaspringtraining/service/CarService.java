package pl.sda.sdaspringtraining.service;

import org.springframework.stereotype.Service;
import pl.sda.sdaspringtraining.NotFoundException;
import pl.sda.sdaspringtraining.api.model.Car;
import pl.sda.sdaspringtraining.api.model.NewCar;
import pl.sda.sdaspringtraining.api.model.UpdateCar;
import pl.sda.sdaspringtraining.domain.CarEntity;
import pl.sda.sdaspringtraining.domain.CarRepository;

import java.rmi.NoSuchObjectException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CarService {

    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void createCar(NewCar newCar) {
        CarEntity entity = new CarEntity(null, newCar.getRegisterPlate(), newCar.getProducer(),
                newCar.getModel(), newCar.getYearOfProduction(), String.join(",", newCar.getOptions()));

        carRepository.save(entity);
    }

    public void updateCar(UpdateCar updateCar) {
        CarEntity carToUpdate = carRepository.findById(updateCar.getId())
                .orElseThrow(() -> new NotFoundException("Car with id " + updateCar.getId() + " not exist"));

        carToUpdate.setRegisterPlate(updateCar.getRegisterPlate());
        carToUpdate.setOptions(String.join(",", updateCar.getOptions()));

        carRepository.save(carToUpdate);
    }

    public Optional<Car> getById(Integer id) {
        return carRepository.findById(id)
                .map(ent -> new Car(ent.getId(), ent.getRegisterPlate(), ent.getProducer(),
                        ent.getModel(), ent.getYearOfProduction(), Arrays.asList(ent.getOptions().split(","))));
    }

    public List<Car> getAll() {
        return carRepository.findAll().stream()
                .map(ent -> new Car(ent.getId(), ent.getRegisterPlate(), ent.getProducer(),
                        ent.getModel(), ent.getYearOfProduction(), Arrays.asList(ent.getOptions().split(","))))
                .collect(Collectors.toList());
    }

    public void deleteById(Integer id) {
        carRepository.deleteById(id);
    }
}
