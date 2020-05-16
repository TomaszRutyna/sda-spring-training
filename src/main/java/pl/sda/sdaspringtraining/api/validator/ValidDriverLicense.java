package pl.sda.sdaspringtraining.api.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DriverLicenseValidator.class)
public @interface ValidDriverLicense {

    String message() default "Driver license is invalid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
