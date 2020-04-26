package pl.sda.sdaspringtraining.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Integer> {

    List<CarEntity> findAllByRegisterPlate(String registerPlate);

    //Wyszukaj wszystkie po marce i modelu
    List<CarEntity> findAllByProducerAndModel(String producer, String model);

    //Wyszukamy wszystkie nowsze niz rok w parametrze
    List<CarEntity> findAllByYearOfProductionGreaterThanEqual(Integer productionYear);

    //Wyszykamy auta z dane przedzialu czasu
    List<CarEntity> findAllByYearOfProductionBetween(Integer productionYearFrom, Integer producationYearTo);

    List<CarEntity> findAllByRegisterPlateStartingWith(String platePrefix);

    Optional<CarEntity> findFirstByIdAndProducer(Integer id, String producer);
    //Skasuj auta producenta
    void deleteByProducer(String producer);
    //Sprawdz ile samochodow ma rejestracje zawierajaca podany ciag
    Long countByRegisterPlateLike(String plateToSearch);

    List<CarEntity> findAllByModelIn(List<String> models);

    //Zapytanie ktorego nie dalo sie wykonac za pomoca query method
    @Query("SELECT car FROM CarEntity car WHERE car.yearOfProduction = (SELECT MAX(c.yearOfProduction) FROM CarEntity c)")
    List<CarEntity> getOnlyNewest();

}
