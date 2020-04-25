package pl.sda.sdaspringtraining.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    String helloWordCommunicate() {
        return "Hello world!";
    }

    @GetMapping("/hello/{name}")
    String helloWorldWithName(@PathVariable String name) {
        return "Hello world, " + name;
    }

    @GetMapping("/multiply")
    String multiply(@RequestParam("f1") Integer factorOne, @RequestParam("f2") Integer factorTwo) {
        return "Wynik mnożenia to " + (factorOne * factorTwo);
    }
}
