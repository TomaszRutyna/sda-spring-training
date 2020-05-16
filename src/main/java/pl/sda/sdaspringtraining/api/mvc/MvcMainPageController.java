package pl.sda.sdaspringtraining.api.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MvcMainPageController {

    @GetMapping("/")
    String mainPage() {
        return "main.html";
    }

}
