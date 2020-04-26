package pl.sda.sdaspringtraining.domain;

import org.springframework.stereotype.Repository;
import pl.sda.sdaspringtraining.api.model.CarSearchCriteria;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomCarRepositoryImpl implements CustomCarRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CarEntity> findByCriteria(CarSearchCriteria searchCriteria) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<CarEntity> query = criteriaBuilder.createQuery(CarEntity.class);
        Root<CarEntity> root = query.from(CarEntity.class);

        List<Predicate> predicates = new ArrayList<>();

        if (searchCriteria.getProductionFrom() != null) {
            predicates.add(criteriaBuilder.ge(root.get("yearOfProduction"), searchCriteria.getProductionFrom()));
        }

        if (searchCriteria.getProductionTo() != null) {
            predicates.add(criteriaBuilder.le(root.get("yearOfProduction"), searchCriteria.getProductionTo()));
        }

        //kolejne warunki

        query.where(predicates.toArray(new Predicate[predicates.size()]));
        return entityManager.createQuery(query).getResultList();
    }
}
