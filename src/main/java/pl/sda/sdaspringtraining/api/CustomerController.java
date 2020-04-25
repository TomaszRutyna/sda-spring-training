package pl.sda.sdaspringtraining.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.sdaspringtraining.api.model.Customer;
import pl.sda.sdaspringtraining.api.model.NewCustomer;
import pl.sda.sdaspringtraining.api.model.UpdateCustomer;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @PostMapping
    ResponseEntity<String> createCustomer(@RequestBody NewCustomer newCustomer) {
        return ResponseEntity.status(HttpStatus.CREATED).body(newCustomer.toString());
    }

    @PutMapping
    String updateCustomer(@RequestBody UpdateCustomer updateCustomer) {
        return updateCustomer.toString();
    }

    @GetMapping
    List<Customer> getAll() {
        return new ArrayList<>();
    }

    @GetMapping("/{id}")
    Customer getById(@PathVariable Integer id) {
        return null;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCustomer(@PathVariable Integer id) {

    }
}
