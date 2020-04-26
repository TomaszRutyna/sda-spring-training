package pl.sda.sdaspringtraining.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

    //Praca wlasna
    List<CustomerEntity> findAllByDriverLicenseNull();
    List<CustomerEntity> findAllByFirstName(String firstName);


}
