package com.example.fooddeliveryapp.service;

import lombok.AllArgsConstructor;
import com.example.fooddeliveryapp.module.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.fooddeliveryapp.repository.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String username) {
        return userRepository.findById(username).get();
    }

    public List<User> filterUsers(String criteria) {
        return userRepository.findUsersByFirstNameContainingOrLastNameContaining(criteria, criteria);
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user, String username) {
        user.setUsername(username);
        return userRepository.save(user);
    }

    public User partiallyUpdateUser(User user, String username) {
        User updatedUser = userRepository.findById(username).get();
        if(user.getFirstName() != null) {
            updatedUser.setFirstName(user.getFirstName());
        }

        if(user.getLastName() != null) {
           updatedUser.setLastName(user.getLastName());
        }

        if(user.getAddress() != null) {
            updatedUser.setAddress(user.getAddress());
        }

        if(user.getPhoneNumber() != null) {
            updatedUser.setPhoneNumber(user.getPhoneNumber());
        }

        if(user.getDateOfBirth() != null) {
            updatedUser.setDateOfBirth(user.getDateOfBirth());
        }
        return userRepository.save(updatedUser);

    }

    public void deleteUser(String username) {
        User user = userRepository.findById(username).get();
        userRepository.delete(user);
    }
}
