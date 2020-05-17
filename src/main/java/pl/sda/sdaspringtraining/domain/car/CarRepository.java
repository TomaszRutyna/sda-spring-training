package pl.sda.sdaspringtraining.domain.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Integer>, CustomCarRepository {

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

    List<CarEntity> findByRents_RentFromIsAfter(LocalDate rentedAfterDate);

    //Praca wlasna:
    List<CarEntity> findAllByYearOfProductionIsLessThan(Integer olderThan);

    @Query("SELECT DISTINCT(car.producer) FROM CarEntity car")
    List<String> findAllDistinctProducers();

    @Query("SELECT car from CarEntity car where car.rents.size = 0")
    List<CarEntity> findAllByWithoutRents();

    List<CarEntity> findAllByProducerLike(String producer);

    @Query("SELECT car from CarEntity car where car.rents.size = (SELECT max(c.rents.size) FROM CarEntity c)")
    List<CarEntity> findMostPopular();

    @Query("SELECT car from CarEntity car WHERE length(car.options) = (SELECT max(length(c.options)) FROM CarEntity c)")
    List<CarEntity> findWithLongestOptionsList();

    List<CarEntity> findAllByOptionsContains(String element);

/*    @Query("SELECT new Car(car.id, car.registerPlate, car.producer, car.model, car.yearOfProduction) FROM CarEntity car" )
    List<Car> findAllCars();*/

    @Query("SELECT car FROM CarEntity car " +
            " inner join car.rents rent WHERE rent.rentFrom > :forDate AND rent.rentTo < :forDate")
    List<CarEntity> findAllRentedForDay(@Param("forDate") LocalDate date);

    @Query("SELECT distinct(car) FROM CarEntity car " +
            "INNER JOIN car.rents rent " +
            "INNER JOIN rent.customer cust " +
            "WHERE cust.address like '%:city%'")
    List<CarEntity> findAllRentedByCustomerFrom(@Param("city") String city);

}