package pl.sda.sdaspringtraining.api.model;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewCustomer {
    private String firstName;
    private String lastName;
    private String address;
    private String driverLicense;
}
