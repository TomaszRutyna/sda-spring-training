package pl.sda.sdaspringtraining.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.sdaspringtraining.api.model.NewUser;
import pl.sda.sdaspringtraining.service.UserService;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    void createUser(@RequestBody NewUser newUser) {
        userService.registerUser(newUser);
    }
}
