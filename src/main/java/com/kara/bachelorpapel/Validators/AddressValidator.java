package com.kara.bachelorpapel.Validators;

import com.kara.bachelorpapel.dto.AddressDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class AddressValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return AddressDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AddressDto addressDto = (AddressDto) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "street", "field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "number", "field.required");

        if (!addressDto.getPostalCode().matches("^\\d{5}$")) {
            errors.rejectValue("postalCode", "postalCode.invalid");
        }

        if (!addressDto.getCity().matches("^[a-zA-Zα-ωΑ-Ω]+$")) {
            errors.rejectValue("city", "city.invalid");
        }

        if (!addressDto.getStreet().matches("^[a-zA-Zα-ωΑ-Ω\\s]+$")) {
            errors.rejectValue("street", "street.invalid");
        }

        if (!addressDto.getNumber().matches("^\\d{1,5}$")) {
            errors.rejectValue("number", "number.invalid");
        }
    }
}

