package pl.sda.sdaspringtraining.api.model;

import lombok.*;

import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    private Integer id;
    private String registerPlate;
    private String producer;
    private String model;
    private int yearOfProduction;
    private List<String> options;
}
