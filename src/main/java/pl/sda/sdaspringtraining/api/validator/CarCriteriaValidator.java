package pl.sda.sdaspringtraining.api.validator;

import pl.sda.sdaspringtraining.api.model.CarSearchCriteria;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CarCriteriaValidator implements ConstraintValidator<ValidCarCriteria, CarSearchCriteria> {
    @Override
    public void initialize(ValidCarCriteria constraintAnnotation) {

    }

    @Override
    public boolean isValid(CarSearchCriteria searchCriteria, ConstraintValidatorContext constraintValidatorContext) {
        if (searchCriteria.getProductionFrom() == null || searchCriteria.getProductionTo() == null) {
            return true;
        }

        return searchCriteria.getProductionFrom() <= searchCriteria.getProductionTo();
    }
}
