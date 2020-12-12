package com.codehub.pf.team4.mappers;

import com.codehub.pf.team4.domains.User;
import com.codehub.pf.team4.model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserToUserModelMapper {

    public UserModel map(User user){
        UserModel userModel = new UserModel();
        userModel.setAfm(user.getAfm());
        userModel.setFirstName(user.getFirstName());
        userModel.setLastName(user.getLastName());
        userModel.setAddress(user.getAddress());
        userModel.setPhoneNumber(user.getPhoneNumber());
        userModel.setPassword(user.getPassword());
        userModel.setHouseType(user.getHouseType());
        userModel.setEmail(user.getEmail());
        return userModel;
    }
}
