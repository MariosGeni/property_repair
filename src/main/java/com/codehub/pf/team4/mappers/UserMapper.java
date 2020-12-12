package com.codehub.pf.team4.mappers;

import com.codehub.pf.team4.domains.User;
import com.codehub.pf.team4.models.UserModel;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class UserMapper {

    public static UserModel mapToUserModel(User user) {
        if (user == null) { return null; }
        UserModel userModel = new UserModel();
        userModel.setFirstName(user.getFirstName());
        userModel.setLastName(user.getLastName());
        userModel.setEmail(user.getEmail());
        userModel.setId(user.getId());
        userModel.setAfm(user.getAfm());
        userModel.setAddress(user.getAddress());
        userModel.setPhoneNumber(user.getPhoneNumber());

        return userModel;
    }

    public List<UserModel> mapToUserModelList(List<User> users){
        return users.stream()
                .map(UserMapper::mapToUserModel)
                .collect(Collectors.toList());
    }

    public Optional<UserModel> mapToRepairModelOptional(User user) {
        return Optional.of(mapToUserModel(user));
    }
}
