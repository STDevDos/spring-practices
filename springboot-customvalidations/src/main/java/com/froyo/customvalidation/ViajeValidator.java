package com.froyo.customvalidation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = ViajeValidatorImpl.class)
@Documented
public @interface ViajeValidator {

    String message() default "ORIGEN Y DESTINO NO PUEDEN SER IGUALES.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
