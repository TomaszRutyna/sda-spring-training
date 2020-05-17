package pl.sda.sdaspringtraining.domain.car;

import pl.sda.sdaspringtraining.api.model.CarSearchCriteria;

import java.util.List;

public interface CustomCarRepository {
    List<CarEntity> findByCriteria(CarSearchCriteria searchCriteria);
}
