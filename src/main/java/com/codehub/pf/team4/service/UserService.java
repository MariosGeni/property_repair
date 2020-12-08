package com.codehub.pf.team4.service;

import com.codehub.pf.team4.domains.Repair;
import com.codehub.pf.team4.domains.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    // get all users
    List<User> getAllUsers();

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

    // given a user id, find all repairs for that user
    List<Repair> getRepairsByUserId(Long id);

    // given an afm number, get all repairs related with the user
    List<Repair> getRepairsByUserAfm(Integer afm);

    // given an email, get all repairs related with the user
    List<Repair> getRepairsByUserEmail(String email);
}
