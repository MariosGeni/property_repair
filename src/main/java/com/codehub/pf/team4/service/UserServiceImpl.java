package com.codehub.pf.team4.service;

import com.codehub.pf.team4.domains.Repair;
import com.codehub.pf.team4.domains.User;
import com.codehub.pf.team4.form.UserForm;
import com.codehub.pf.team4.mapper.UserFormToUserMapper;
import com.codehub.pf.team4.mapper.UserToUserModelMapper;
import com.codehub.pf.team4.model.UserModel;
import com.codehub.pf.team4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserFormToUserMapper userMapper;

    @Autowired
    private UserToUserModelMapper userModelMapper;

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findUserByAfm(String afm) {
        Integer intAfm = Integer.parseInt(afm);
        return userRepository.findByAfm(intAfm);
    }

    @Override
    public Optional<User> updateUser(User toBeUpdatedUser) {
        Long userId = toBeUpdatedUser.getId();
        if (userId == null || findUserById(userId).isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(userRepository.save(toBeUpdatedUser));
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<Repair> getRepairsByUserAfm(String afm) {
        Integer intAfm = Integer.parseInt(afm);
        return userRepository.findRepairsByAfm(intAfm);
    }

    @Override
    public List<Repair> getRepairsByUserEmail(String email) {
        return userRepository.findRepairsByUserEmail(email);
    }

    @Override
    public UserModel createUser(UserForm userForm) {
        User user = userMapper.map(userForm);
        User newUser = userRepository.save(user);
        return userModelMapper.map(newUser);
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        // if id is empty or user paired with this id doesn't exist
        if (id == null || findUserById(id).isEmpty()) {
            System.out.println("Id is null or user not found"); // display a simple message
            return;
        }
        userRepository.deleteById(id);
    }

    @Override
    public List<Repair> getRepairsByUserId(Long id) {
        return userRepository.findRepairsByUserId(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
