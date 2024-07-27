package com.example.varachha.Annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {sizevalidation.class})
public @interface Fixsize {
    String message() default "Account number must be 10 digits";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
