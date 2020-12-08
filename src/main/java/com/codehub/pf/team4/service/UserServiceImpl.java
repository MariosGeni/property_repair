package com.codehub.pf.team4.service;

import com.codehub.pf.team4.domains.Repair;
import com.codehub.pf.team4.domains.User;
import com.codehub.pf.team4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findUserByAfm(Integer afm) {
        return userRepository.findByAfm(afm);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<Repair> getRepairsByUserAfm(Integer afm) {
        return userRepository.findRepairsByAfm(afm);
    }

    @Override
    public List<Repair> getRepairsByUserEmail(String email) {
        return userRepository.findRepairsByUserEmail(email);
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
