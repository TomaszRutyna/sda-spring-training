package pl.sda.sdaspringtraining.api.model;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCustomer {
    private int id;
    private String newAddress;
}
