package pl.sda.sdaspringtraining.api.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
public class MvcMainPageController {

    @GetMapping("/")
    ModelAndView mainPage(@RequestParam(required = false) String branch) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("main.html");

        mav.addObject("branch", branch);
        mav.addObject("now", LocalDate.now().toString());
        return mav;
    }

}
