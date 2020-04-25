package pl.sda.sdaspringtraining.domain;

import lombok.*;

import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarEntity {
    private Integer id;
    private String registerPlate;
    private String producer;
    private String model;
    private int yearOfProduction;
    private List<String> options;
}
