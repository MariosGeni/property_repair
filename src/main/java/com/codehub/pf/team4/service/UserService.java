package com.codehub.pf.team4.service;

import com.codehub.pf.team4.Tables.User;

import java.util.Optional;

public interface UserService {

    // find user by id
    Optional<User> findUserById(Long id);

    // find user by afm
    Optional<User> findUserByAfm(Integer afm);

    // find user by email
    Optional<User> findUserByEmail(String email);

    // add user
    User addUser(User user);

    // delete user by id
    void deleteById(Long id);

}
