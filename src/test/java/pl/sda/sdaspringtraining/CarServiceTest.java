package pl.sda.sdaspringtraining;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;
import pl.sda.sdaspringtraining.api.model.NewCar;
import pl.sda.sdaspringtraining.domain.car.CarEntity;
import pl.sda.sdaspringtraining.domain.car.CarRepository;
import pl.sda.sdaspringtraining.service.CarService;

import java.util.ArrayList;
import java.util.Collections;

public class CarServiceTest {

    private CarRepository carRepository = Mockito.mock(CarRepository.class);

    private CarService carService = new CarService(carRepository);

    @Before
    public void setup() {
        carRepository = Mockito.mock(CarRepository.class);
        carService = new CarService(carRepository);
    }

    @Test
    public void shouldCreateCar() {
        //given
        NewCar newCar = new NewCar("LU12345", "Ford", "Focus", 2015, new ArrayList<>());
        //when
        carService.createCar(newCar);
        //then
        Mockito.verify(carRepository).save(Mockito.any());
    }

    @Test(expected = AlreadyExistsException.class)
    public void shouldNotCreateCarWhenAlreadyExistsWithSameLicensePlate() {
        //given
        NewCar newCar = new NewCar("LU12345", "Ford", "Focus", 2015, new ArrayList<>());
        Mockito.when(carRepository.findAllByRegisterPlate("LU12345")).thenReturn(Collections.singletonList(new CarEntity()));
        //when
        carService.createCar(newCar);
    }
}
