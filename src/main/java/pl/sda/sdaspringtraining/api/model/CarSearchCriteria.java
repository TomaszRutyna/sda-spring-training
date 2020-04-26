package pl.sda.sdaspringtraining.api.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CarSearchCriteria {
    private Integer productionFrom;
    private Integer productionTo;
    private String producer;
    private String option;
}
