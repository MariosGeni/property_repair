package com.codehub.pf.team4.service;

import com.codehub.pf.team4.forms.UserForm;
import com.codehub.pf.team4.mappers.RepairMapper;
import com.codehub.pf.team4.mappers.UserFormMapper;
import com.codehub.pf.team4.mappers.UserMapper;
import com.codehub.pf.team4.models.RepairModel;
import com.codehub.pf.team4.models.UserModel;
import com.codehub.pf.team4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<UserModel> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::mapToUserModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserModel> findUserById(Long id) {
        return UserMapper.mapToUserModelOptional(userRepository.findById(id).orElse(null));
    }

    @Override
    public Optional<UserModel> findUserByAfm(String afm) {
        Integer intAfm = Integer.parseInt(afm);
        return UserMapper.mapToUserModelOptional(userRepository.findByAfm(intAfm).orElse(null));
    }

    @Override
    public Optional<UserModel> updateUser(UserForm toBeUpdatedUser) {
        return UserMapper.mapToUserModelOptional(userRepository.save(UserFormMapper.mapToUser(toBeUpdatedUser)));
    }

    @Override
    public Optional<UserModel> findUserByEmail(String email) {
        return UserMapper.mapToUserModelOptional(userRepository.findByEmail(email).orElse(null));
    }

    @Override
    public List<RepairModel> getRepairsByUserAfm(String afm) {
        Integer intAfm = Integer.parseInt(afm);
        return userRepository.findRepairsByAfm(intAfm)
                .stream()
                .map(repair -> RepairMapper.mapToRepairModel(repair))
                .collect(Collectors.toList());
    }

    @Override
    public List<RepairModel> getRepairsByUserEmail(String email) {
        return userRepository.findRepairsByUserEmail(email)
                .stream()
                .map(repair -> RepairMapper.mapToRepairModel(repair))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserModel> addUser(UserForm newUser) {
        return UserMapper.mapToUserModelOptional(userRepository.save(UserFormMapper.mapToUser(newUser)));
    }

    @Override
    public boolean deleteById(Long id) {
        // if id is empty or user paired with this id doesn't exist
        if (id == null || findUserById(id).isEmpty()) {
            System.out.println("Id is null or user not found"); // display a simple message
            return false; // deletion unsuccessful
        }

        userRepository.deleteById(id);
        return true;
    }

    @Override
    public List<RepairModel> getRepairsByUserId(Long id) {
        return userRepository.findRepairsByUserId(id)
                .stream()
                .map(RepairMapper::mapToRepairModel)
                .collect(Collectors.toList());
    }
}
