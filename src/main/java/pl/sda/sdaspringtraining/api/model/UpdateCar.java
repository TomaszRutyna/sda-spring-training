package pl.sda.sdaspringtraining.api.model;

import lombok.*;

import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCar {
    private Integer id;
    private String registerPlate;
    private List<String> options;
}
