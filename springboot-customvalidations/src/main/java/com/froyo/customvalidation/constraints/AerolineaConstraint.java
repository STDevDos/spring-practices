package com.froyo.customvalidation.constraints;

import com.froyo.customvalidation.AerolineaValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = AerolineaValidator.class)
@Documented
public @interface AerolineaConstraint {

    String message() default "AEROLINEA NO VALIDA.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

