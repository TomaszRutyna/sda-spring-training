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

    public Car(Integer id, String registerPlate, String producer, String model, int yearOfProduction) {
        this.id = id;
        this.registerPlate = registerPlate;
        this.producer = producer;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
    }
}
