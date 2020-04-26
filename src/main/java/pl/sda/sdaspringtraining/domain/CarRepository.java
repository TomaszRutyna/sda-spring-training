package pl.sda.sdaspringtraining.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Integer> {

    List<CarEntity> findAllByRegisterPlate(String registerPlate);
}
