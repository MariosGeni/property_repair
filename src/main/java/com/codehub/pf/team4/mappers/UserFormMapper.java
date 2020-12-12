package com.codehub.pf.team4.mappers;

import com.codehub.pf.team4.domains.User;
import com.codehub.pf.team4.enums.HouseType;
import com.codehub.pf.team4.forms.UserForm;
import org.springframework.stereotype.Component;

@Component
public class UserFormMapper {

    public static User mapToUser(UserForm userForm){
        if(userForm == null) return null;

        User user = new User();
        user.setAfm(Integer.parseInt(userForm.getAfm()));
        user.setEmail(userForm.getEmail());
        user.setFirstName(userForm.getFirstName());
        user.setLastName(userForm.getLastName());
        user.setAddress(userForm.getAddress());
        user.setPhoneNumber(Long.parseLong(userForm.getPhoneNumber()));
        user.setHouseType(HouseType.valueOf(userForm.getHouseType()));

        if(!userForm.getId().isEmpty()) {
            user.setId(Long.parseLong(userForm.getId()));
        } else {
            user.setPassword(userForm.getPassword());
        }

        return user;
    }
}
