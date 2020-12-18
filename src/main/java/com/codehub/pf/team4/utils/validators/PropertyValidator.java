package com.codehub.pf.team4.utils.validators;

import com.codehub.pf.team4.enums.HouseType;
import com.codehub.pf.team4.forms.PropertyForm;
import com.codehub.pf.team4.models.PropertyModel;
import com.codehub.pf.team4.models.UserModel;
import com.codehub.pf.team4.service.PropertyService;
import com.codehub.pf.team4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Arrays;
import java.util.Optional;

@Component
public class PropertyValidator implements Validator {

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private UserService userService;

    @Override
    public  boolean supports(Class<?> aClass){ return PropertyForm.class.isAssignableFrom(aClass);}

    @Override
    public void validate(Object target, Errors errors){
        PropertyForm propertyForm = (PropertyForm) target;

        if(propertyForm.getId() == null) propertyForm.setId("");
        if(propertyForm.getUserId() == null) propertyForm.setUserId("");

        if(!propertyForm.getUserId().isBlank() && UserValidator.isNumeric(propertyForm.getId())){
            Optional<UserModel> userWithGivenPropertyUserId = userService.findUserById(Long.parseLong(propertyForm.getUserId()));
            if(userWithGivenPropertyUserId.isEmpty()){
                errors.rejectValue("userId", "owner.id.not.exists");
            }
        }

        if (doesExist("propertyId", propertyForm.getPropertyID()) && propertyForm.getId().isBlank()) {
            errors.rejectValue("afm", "afm.exists");
        }

        if(!propertyForm.getId().isBlank()){
            if(UserValidator.isNumeric(propertyForm.getId())){
                Optional<PropertyModel> propertyWithGivenId = propertyService.getPropertyById(Long.parseLong(propertyForm.getId()));
            }
        }
        Optional<HouseType> houseType = Arrays.stream(HouseType.values())
                .filter(type -> type.toString().equalsIgnoreCase(propertyForm.getHouseType()))
                .findFirst();
        if(houseType.isEmpty()) errors.rejectValue("houseType", "houseType.not.match");
    }

    private boolean doesExist( String field, String value ){
        if (field.equalsIgnoreCase("propertyId")) {
            if (value != null) {
                if (!value.isBlank() && UserValidator.isNumeric(value)) {
                    try{
                        return propertyService.getPropertyByPropertyId(Long.parseLong(value)).isPresent();
                    } catch(Exception exc){}
                }
            }
        }
        return false;
    }


}
