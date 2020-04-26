package pl.sda.sdaspringtraining.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.sdaspringtraining.AlreadyExistsException;
import pl.sda.sdaspringtraining.NotFoundException;
import pl.sda.sdaspringtraining.api.model.Car;
import pl.sda.sdaspringtraining.api.model.NewCar;
import pl.sda.sdaspringtraining.api.model.UpdateCar;
import pl.sda.sdaspringtraining.domain.CarEntity;
import pl.sda.sdaspringtraining.domain.CarRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {

    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void createCar(NewCar newCar) {
        List<CarEntity> carsWithSamePlate = carRepository.findAllByRegisterPlate(newCar.getRegisterPlate());
        if (!carsWithSamePlate.isEmpty()) {
            throw new AlreadyExistsException("Car with plate " + newCar.getRegisterPlate() + " already exists");
        }

        CarEntity entity = new CarEntity(null, newCar.getRegisterPlate(), newCar.getProducer(),
                newCar.getModel(), newCar.getYearOfProduction(), String.join(",", newCar.getOptions()), null);

        carRepository.save(entity);
    }

    @Transactional
    public void updateCar(UpdateCar updateCar) {
        CarEntity carToUpdate = carRepository.findById(updateCar.getId())
                .orElseThrow(() -> new NotFoundException("Car with id " + updateCar.getId() + " not exist"));

        carToUpdate.setRegisterPlate(updateCar.getRegisterPlate());
        carToUpdate.setOptions(String.join(",", updateCar.getOptions()));
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
