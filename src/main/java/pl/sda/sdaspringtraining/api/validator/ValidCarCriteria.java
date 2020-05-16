package pl.sda.sdaspringtraining.api.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(TYPE)
@Retention(RUNTIME)
@Constraint(validatedBy = CarCriteriaValidator.class)
public @interface ValidCarCriteria {

    String message() default "Car criteria is invalid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

