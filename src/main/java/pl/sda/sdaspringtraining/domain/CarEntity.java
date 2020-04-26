package pl.sda.sdaspringtraining.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cars")
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String registerPlate;
    private String producer;
    private String model;
    private int yearOfProduction;
    private String options;
    @OneToMany(mappedBy = "car")
    private Set<RentEntity> rents;

}
