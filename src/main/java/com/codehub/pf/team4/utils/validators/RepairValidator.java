package com.codehub.pf.team4.utils.validators;

import com.codehub.pf.team4.enums.RepairType;
import com.codehub.pf.team4.enums.State;
import com.codehub.pf.team4.forms.RepairForm;
import com.codehub.pf.team4.models.RepairModel;
import com.codehub.pf.team4.models.UserModel;
import com.codehub.pf.team4.service.RepairService;
import com.codehub.pf.team4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Arrays;
import java.util.Optional;

@Component
public class RepairValidator implements Validator {

    @Autowired
    private RepairService repairService;

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return RepairForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RepairForm repairForm = (RepairForm) target;
        // Here we add our custom validation logic
        // Updated repair does exist?
        if(!repairForm.getId().isEmpty()) {
            Optional<RepairModel> repairWithGivenEmail = repairService.getRepairById(Long.parseLong(repairForm.getId()));
            if (repairWithGivenEmail.isEmpty()) {
                errors.rejectValue("id", "Repair with this id doesnt exist");
            }
        }

        Optional<UserModel> theUser = userService.findUserById(Long.parseLong(repairForm.getId()));
        if (theUser.isEmpty()) {
            errors.rejectValue("userId", "User with this id doesnt exist");
        }

        Optional<State> state = Arrays.stream(State.values())
                .filter(type -> type.toString().equalsIgnoreCase(repairForm.getState()))
                .findFirst();

        Optional<RepairType> repairType = Arrays.stream(RepairType.values())
                .filter(type -> type.toString().equalsIgnoreCase(repairForm.getRepairType()))
                .findFirst();

        if(state.isEmpty()) errors.reject("state", "State doesn't match!");
        if(repairType.isEmpty()) errors.reject("houseType", "House Type doesn't match!");
    }
}
