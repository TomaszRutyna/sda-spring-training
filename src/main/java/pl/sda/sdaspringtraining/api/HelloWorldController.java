package pl.sda.sdaspringtraining.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
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

    @GetMapping("/count/{operation}")
    String count(@PathVariable String operation, @RequestParam("f1") Integer factorOne, @RequestParam("f2") Integer factorTwo) {
        String result = "Wynik to ";
        switch (operation) {
            case "dodawanie":
                result += factorOne + factorTwo;
                break;
            case "odejmowanie":
                result += factorOne - factorTwo;
                break;
            case "mnozenie":
                result += factorOne * factorTwo;
                break;
            case "dzielenie":
                result += factorOne / factorTwo;
                break;
            default:
                result = "Błąd";
        }
        return result;
    }
}
