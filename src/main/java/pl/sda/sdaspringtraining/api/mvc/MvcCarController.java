package pl.sda.sdaspringtraining.api.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.sdaspringtraining.service.CarService;

@Controller
@RequestMapping("/cars")
public class MvcCarController {

    private final CarService carService;

    public MvcCarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    ModelAndView showAllCars() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("cars/cars.html");
        mav.addObject("cars", carService.getAll());
        return mav;
    }

    @GetMapping("/{id}")
    ModelAndView showCarDetails(@PathVariable Integer id) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("cars/carDetails.html");
        mav.addObject("car", carService.getById(id).get());
        return mav;
    }
}
