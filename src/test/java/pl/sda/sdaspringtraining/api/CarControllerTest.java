package pl.sda.sdaspringtraining.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import pl.sda.sdaspringtraining.api.model.NewCar;
import pl.sda.sdaspringtraining.domain.car.CarEntity;
import pl.sda.sdaspringtraining.domain.car.CarRepository;

import java.time.LocalDate;
import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CarControllerTest {

    @Autowired
    CarRepository carRepository;

    @Autowired
    TestRestTemplate testRestTemplate;

    @Before
    public void before() {
        carRepository.deleteAll();
    }

    @Test
    public void shouldCreateNewCar() {
        //given
        NewCar newCar = new NewCar("LU12345", "Ford", "Focus", 2015, new ArrayList<>());
        HttpEntity<NewCar> httpEntity = new HttpEntity<>(newCar);
        //when
        ResponseEntity<Void> rsp = testRestTemplate.exchange("/api/cars", HttpMethod.POST, httpEntity, Void.class);
        //then
        Assert.assertEquals(201, rsp.getStatusCodeValue());

        Assert.assertEquals(1, carRepository.count());
    }

    @Test
    public void shouldNotCreateNewCarWhenProdDateIsInFuture() {
        //given
        NewCar newCar = new NewCar("LU12345", "Ford", "Focus",
                LocalDate.now().getYear() + 2, new ArrayList<>());
        HttpEntity<NewCar> httpEntity = new HttpEntity<>(newCar);
        //when
        ResponseEntity<Void> rsp = testRestTemplate.exchange("/api/cars", HttpMethod.POST, httpEntity, Void.class);
        //then
        Assert.assertEquals(400, rsp.getStatusCodeValue());

        Assert.assertEquals(0, carRepository.count());
    }

    @Test
    public void shouldNotCreateNewCarBecauseRegPlatesAlreadyExists() {
        //given
        carRepository.save(new CarEntity(null, "LU12345", "Ford", "Focus", 2015, null, null));

        NewCar newCar = new NewCar("LU12345", "Ford", "Focus", 2015, new ArrayList<>());
        HttpEntity<NewCar> httpEntity = new HttpEntity<>(newCar);
        //when
        ResponseEntity<Void> rsp = testRestTemplate.exchange("/api/cars", HttpMethod.POST, httpEntity, Void.class);
        //then
        Assert.assertEquals(500, rsp.getStatusCodeValue());

        Assert.assertEquals(1, carRepository.count());
    }


}
