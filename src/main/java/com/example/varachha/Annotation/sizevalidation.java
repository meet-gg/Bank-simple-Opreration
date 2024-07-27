package com.example.varachha.Annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
public class sizevalidation implements ConstraintValidator<Fixsize, Long> {
    public void initialize(sizevalidation accountNumber) {
    }

    @Override
    public boolean isValid(Long accountNumber, ConstraintValidatorContext context) {
        if (accountNumber == null) {
            return false;
        }
        String accountNumberString = accountNumber.toString();
        return accountNumberString.length() == 10;
    }
}
