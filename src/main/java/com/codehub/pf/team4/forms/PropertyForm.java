package com.codehub.pf.team4.forms;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
public class PropertyForm {

    private static final String YEAR_OF_CONSTRUCTION_PATTERN = "^[0-9]*$";
    private static final String ID_PATTERN = "^[0-9]*$";
    private static final String USER_ID_PATTERN = "^[0-9]*$";

    @Pattern(regexp = YEAR_OF_CONSTRUCTION_PATTERN, message = "Year of construction pattern doesn't match")
    @NotEmpty(message = "Year of construction can't be empty")
    private String yearOfConstruction;

    //Validated in PropertyValidator
    @Pattern(regexp = ID_PATTERN, message = "Id pattern doesn't match")
    private String id;

    @Pattern(regexp = USER_ID_PATTERN, message = "User ID pattern doesn't match")
    private String userId;

    private String houseType;

    // no validations needed
    private String address;

}
