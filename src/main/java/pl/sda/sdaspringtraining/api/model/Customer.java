package pl.sda.sdaspringtraining.api.model;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private Integer id;
    private String firstName;
    private String lastName;
    private String driverLicense;
    private String address;
}
