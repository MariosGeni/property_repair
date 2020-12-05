package com.codehub.pf.team4.Property_Repairs.service;

import com.codehub.pf.team4.Property_Repairs.Tables.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> fetchUserById(Long id);

}
