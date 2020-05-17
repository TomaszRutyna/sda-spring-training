package pl.sda.sdaspringtraining.domain.rent;

import lombok.*;
import pl.sda.sdaspringtraining.domain.car.CarEntity;
import pl.sda.sdaspringtraining.domain.customer.CustomerEntity;

import javax.persistence.*;
import java.time.LocalDate;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rents")
public class RentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate rentFrom;
    private LocalDate rentTo;
    @ManyToOne
    @JoinColumn(name = "car_id")
    private CarEntity car;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;
}
