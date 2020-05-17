package pl.sda.sdaspringtraining.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewUser {
    private String login;
    private String password;
    private String role;
}
