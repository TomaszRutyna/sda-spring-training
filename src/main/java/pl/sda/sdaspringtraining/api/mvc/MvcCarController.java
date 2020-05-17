package pl.sda.sdaspringtraining.api.mvc;

import jdk.internal.dynalink.MonomorphicCallSite;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.sdaspringtraining.api.model.NewCar;
import pl.sda.sdaspringtraining.service.CarService;

import javax.validation.Valid;

@Controller
@RequestMapping("/cars")
public class MvcCarController {

    private final CarService carService;

    public MvcCarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/add")
    ModelAndView addNewCarPage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("cars/addCar.html");
        //WAZNE
        mav.addObject("car", new NewCar());

        return mav;
    }

    @PostMapping("/add")
    String addNewCar(@Valid @ModelAttribute("car") NewCar newCar, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "error.html";
        }

        carService.createCar(newCar);
        return "redirect:/cars";
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
