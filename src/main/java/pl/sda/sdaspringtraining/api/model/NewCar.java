package pl.sda.sdaspringtraining.api.model;

import lombok.*;
import pl.sda.sdaspringtraining.api.validator.CurrentYearOrOlder;

import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewCar {
    private String registerPlate;
    private String producer;
    private String model;
    @CurrentYearOrOlder
    private int yearOfProduction;
    private List<String> options;

}
