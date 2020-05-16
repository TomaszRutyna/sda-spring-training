package pl.sda.sdaspringtraining.api.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class CurrentYearOrOlderValidator implements ConstraintValidator<CurrentYearOrOlder, Integer> {
    @Override
    public void initialize(CurrentYearOrOlder constraintAnnotation) {
    }

    @Override
    public boolean isValid(Integer year, ConstraintValidatorContext constraintValidatorContext) {
        Integer currentYear = LocalDate.now().getYear();

        return year <= currentYear;
    }
}
