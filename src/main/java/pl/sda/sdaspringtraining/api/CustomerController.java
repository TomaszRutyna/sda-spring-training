package pl.sda.sdaspringtraining.api;

import lombok.RequiredArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.sda.sdaspringtraining.api.model.Customer;
import pl.sda.sdaspringtraining.api.model.NewCustomer;
import pl.sda.sdaspringtraining.api.model.UpdateCar;
import pl.sda.sdaspringtraining.api.model.UpdateCustomer;
import pl.sda.sdaspringtraining.service.CustomerService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    ResponseEntity createCustomer(@Valid @RequestBody NewCustomer newCustomer, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.unprocessableEntity().body(
                    bindingResult.getAllErrors().stream()
                            .map(DefaultMessageSourceResolvable::getDefaultMessage)
            .collect(Collectors.toList()));
        }

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
