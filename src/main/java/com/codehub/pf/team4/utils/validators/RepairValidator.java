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
import java.util.regex.Pattern;

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

        if(repairForm.getId() == null) repairForm.setId(""); // avoid null pointer exception
        if(repairForm.getUserId() == null) repairForm.setUserId(""); // avoid null pointer exception

        // Here we add our custom validation logic
        // UPDATE OPERATION does repair with this id exist?


        try {
            Optional<UserModel> userWithGivenRepairUserId = userService.findUserById(Long.parseLong(repairForm.getUserId()));
            if (userWithGivenRepairUserId.isEmpty()) {
                errors.rejectValue("userId", "owner.id.not.exists");
            }
        } catch(Exception e) {
            errors.rejectValue("userId", "owner.id.not.exists");
        }

        Optional<State> state = Arrays.stream(State.values())
                .filter(type -> type.toString().equalsIgnoreCase(repairForm.getState()))
                .findFirst();

        Optional<RepairType> repairType = Arrays.stream(RepairType.values())
                .filter(type -> type.toString().equalsIgnoreCase(repairForm.getRepairType()))
                .findFirst();

        if(state.isEmpty()) errors.rejectValue("state", "state.not.match");
        if(repairType.isEmpty()) errors.rejectValue("repairType", "repairType.not.match");
    }
}