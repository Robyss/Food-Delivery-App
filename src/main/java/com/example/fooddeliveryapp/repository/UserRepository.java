package com.example.fooddeliveryapp.repository;

import com.example.fooddeliveryapp.module.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    List<User> findAll();

    List<User> findUsersByFirstNameContainingOrLastNameContaining(String criteria1, String criteria2);

//    @Query("select u from User u where u.firstName =: name")
//    Optional<List<User>>findUserByFirstName(String name);
}
