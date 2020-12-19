package com.codehub.pf.team4.service;

import com.codehub.pf.team4.forms.UserForm;
import com.codehub.pf.team4.models.PropertyModel;
import com.codehub.pf.team4.models.RepairModel;
import com.codehub.pf.team4.models.UserModel;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserModel> getAllUsers();

    Optional<UserModel> findUserById(Long id);

    Optional<UserForm> findUserByIdAsUserForm(Long id);

    Optional<UserModel> findUserByAfm(String afm);

    Optional<UserModel> findUserByEmail(String email);

    Optional<UserModel> addUser(UserForm user);

    Optional<UserModel> updateUser(UserForm user);

    boolean deleteById(Long id);

    List<RepairModel> getRepairsByUserId(Long id);

    List<RepairModel> getRepairsByUserAfm(String afm);

    List<RepairModel> getRepairsByUserEmail(String email);

    Page<UserModel> findAllAsPage(int page);

    List<PropertyModel> getPropertiesByUserAfm(String afm);
}
