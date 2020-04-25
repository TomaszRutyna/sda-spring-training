package pl.sda.sdaspringtraining.domain;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity {
    private Integer id;
    private String firstName;
    private String lastName;
    private String driverLicense;
    private String address;
}
