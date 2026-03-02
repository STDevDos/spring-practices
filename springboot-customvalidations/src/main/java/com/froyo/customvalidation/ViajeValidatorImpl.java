package com.froyo.customvalidation;

import com.froyo.model.ViajeRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

public class ViajeValidatorImpl implements ConstraintValidator<ViajeValidator, ViajeRequest> {

    @Override
    public boolean isValid(ViajeRequest value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return !StringUtils.equalsIgnoreCase(value.getOrigin(), value.getDestination());
    }
}
