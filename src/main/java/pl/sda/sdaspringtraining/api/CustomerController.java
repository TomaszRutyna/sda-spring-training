package pl.sda.sdaspringtraining.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.sdaspringtraining.api.model.NewCustomer;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @PostMapping
    String createCustomer(@RequestBody NewCustomer newCustomer) {
        return newCustomer.toString();
    }

}
