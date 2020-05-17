package pl.sda.sdaspringtraining.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.sdaspringtraining.api.model.NewUser;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping
    void createUser(@RequestBody NewUser newUser) {

    }
}
