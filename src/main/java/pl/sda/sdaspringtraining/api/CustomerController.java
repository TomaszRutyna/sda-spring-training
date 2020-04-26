package pl.sda.sdaspringtraining.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.sdaspringtraining.api.model.Customer;
import pl.sda.sdaspringtraining.api.model.NewCustomer;
import pl.sda.sdaspringtraining.api.model.UpdateCar;
import pl.sda.sdaspringtraining.api.model.UpdateCustomer;
import pl.sda.sdaspringtraining.service.CustomerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    ResponseEntity<Void> createCustomer(@RequestBody NewCustomer newCustomer) {
        customerService.createCustomer(newCustomer);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    void updateCustomer(@RequestBody UpdateCustomer updateCustomer) {
        customerService.updateCustomer(updateCustomer);
    }

    @GetMapping
    List<Customer> getAll() {
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<Customer> getById(@PathVariable Integer id) {
        Optional<Customer> customer = customerService.getById(id);
        return customer.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCustomer(@PathVariable Integer id) {
        customerService.deleteById(id);
    }
}
