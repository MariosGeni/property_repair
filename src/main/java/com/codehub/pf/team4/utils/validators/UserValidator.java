package com.codehub.pf.team4.utils.validators;

import com.codehub.pf.team4.enums.HouseType;
import com.codehub.pf.team4.forms.UserForm;
import com.codehub.pf.team4.models.UserModel;
import com.codehub.pf.team4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Arrays;
import java.util.*;
import java.util.Optional;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserForm userForm = (UserForm) target;

        // to avoid null pointer
        if (userForm.getId() == null) userForm.setId("");
        if (userForm.getPassword() == null) userForm.setPassword("");

        // check if user with same email or afm exist and id == null so its CREATE OPERATION
        if (doesExist("email", userForm.getEmail()) && userForm.getId().isEmpty()) {
            errors.rejectValue("email", "email.exists");
        }

       try {
           if (doesExist("afm", userForm.getAfm()) && userForm.getId().isBlank()) {
               errors.rejectValue("afm", "afm.exists");
           }
       } catch(Exception e){

       }

        // UPDATE RELATED > Check if user exists before update
        if (doesExist("id", userForm.getId())) {
            errors.rejectValue("email", "email.exists");
        }

        Optional<HouseType> houseType = Arrays.stream(HouseType.values())
                .filter(type -> type.toString().equalsIgnoreCase(userForm.getHouseType()))
                .findFirst();

        if(houseType.isEmpty()) errors.rejectValue("houseType", "houseType.not.match");
    }

    private boolean doesExist(String field, String value) {

        if(field.equalsIgnoreCase("email")) {
            return userService.findUserByEmail(value).isPresent();
        }

        if (field.equalsIgnoreCase("afm")) {
            return userService.findUserByAfm(value).isPresent();
        }

        if (field.equalsIgnoreCase("id")) {
            if(!value.isEmpty()) {
                return userService.findUserById(Long.parseLong(value)).isPresent();
            }
        }

        return false;
    }

    // simple function to check if string is numeric or not
    public boolean isNumeric(String toBeChecked) {
        return toBeChecked.chars().allMatch(Character::isDigit);
    }

}