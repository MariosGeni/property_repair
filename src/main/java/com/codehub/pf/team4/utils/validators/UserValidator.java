package com.codehub.pf.team4.utils.validators;

import com.codehub.pf.team4.domains.User;
import com.codehub.pf.team4.enums.HouseType;
import com.codehub.pf.team4.forms.UserForm;
import com.codehub.pf.team4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Arrays;
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
        // Here we add our custom validation logic
        Optional<User> usersWithGivenEmail = userService.findUserByEmail(userForm.getEmail());
        if (!usersWithGivenEmail.isEmpty()) {
            errors.rejectValue("email", "User with this email already exists");
        }

        Optional<HouseType> houseType = Arrays.stream(HouseType.values())
                .filter(type -> type.toString().equalsIgnoreCase(userForm.getHouseType()))
                .findFirst();

        if(houseType.isEmpty()) errors.reject("houseType", "House Type doesn't match!");
    }
}
