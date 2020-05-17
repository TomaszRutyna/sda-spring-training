package pl.sda.sdaspringtraining.domain.rent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentRepository extends JpaRepository<RentEntity, Long> {

    List<RentEntity> findByCustomer_AddressLike(String city);

}
