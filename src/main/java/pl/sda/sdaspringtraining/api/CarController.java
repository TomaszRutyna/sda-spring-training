package pl.sda.sdaspringtraining.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.sdaspringtraining.api.model.*;
import pl.sda.sdaspringtraining.service.CarService;
import pl.sda.sdaspringtraining.service.CustomerService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @PostMapping("/search")
    List<Car> findByCriteria(@Valid @RequestBody CarSearchCriteria searchCriteria) {
        return new ArrayList<>();
    }

    @PostMapping
    ResponseEntity<Void> car(@Valid @RequestBody NewCar newCar) {
        carService.createCar(newCar);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    void updateCar(@RequestBody UpdateCar updateCar) {
        carService.updateCar(updateCar);
    }

    @GetMapping
    List<Car> getAll() {
        return carService.getAll();
    }

    @GetMapping("/{id}")
    Car getById(@PathVariable Integer id) {
        return carService.getById(id).get();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCar(@PathVariable Integer id) {
        carService.deleteById(id);
    }
}
