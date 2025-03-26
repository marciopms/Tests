package com.example.viasoft.utils;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
public class ValidatorUtils {

    public void validateFields(Object dto) throws Exception {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Object>> violations = validator.validate(dto);

        if (!violations.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (ConstraintViolation<Object> violation : violations) {
                stringBuilder.append(violation.getMessage()).append("\n");
            }
            throw new Exception(stringBuilder.toString());
        }
    }
}
