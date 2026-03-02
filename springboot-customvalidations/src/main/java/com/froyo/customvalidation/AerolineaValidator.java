package com.froyo.customvalidation;

import com.froyo.customvalidation.constraints.AerolineaConstraint;
import org.apache.commons.lang3.StringUtils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class AerolineaValidator implements ConstraintValidator<AerolineaConstraint, String> {

    private List<String> aerolineas = Arrays.asList("AEROMEXICO", "INTERJET", "VIVAAEROBUS", "VOLARIS");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return aerolineas.contains(StringUtils.upperCase(value));
    }
}

