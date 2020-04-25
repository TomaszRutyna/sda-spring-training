package pl.sda.sdaspringtraining.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    String helloWordCommunicate() {
        return "Hello world!";
    }
}
