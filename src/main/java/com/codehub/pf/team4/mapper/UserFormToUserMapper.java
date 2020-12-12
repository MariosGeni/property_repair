package com.codehub.pf.team4.mapper;

import com.codehub.pf.team4.domains.User;
import com.codehub.pf.team4.form.UserForm;
import org.springframework.stereotype.Component;

@Component
public class UserFormToUserMapper {

    public User map(UserForm userForm){
        User user = new User();
        user.setAfm(userForm.getAfm());
        user.setFirstName(userForm.getFirstName());
        user.setLastName(userForm.getLastName());
        user.setAddress(userForm.getAddress());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setPassword(userForm.getPassword());
        user.setHouseType(userForm.getHouseType());
        return user;
    }
}
