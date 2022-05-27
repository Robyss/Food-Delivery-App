package com.example.fooddeliveryapp.controller;

import com.example.fooddeliveryapp.service.UserService;
import lombok.AllArgsConstructor;
import com.example.fooddeliveryapp.module.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;


    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }


    @GetMapping("/{username}")
    public ResponseEntity<User> getUserById(@PathVariable String username) {
        return ResponseEntity.ok(userService.getUserById(username));
    }

    @GetMapping("/search")
    public ResponseEntity<List<User>> filterUsers(@RequestParam String criteria) {
        return ResponseEntity.ok(userService.filterUsers(criteria));
    }


    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.addUser(user));
    }


    @PutMapping("/{username}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable String username) {
        return ResponseEntity.ok(userService.updateUser(user, username));
    }


    @PatchMapping("/{username}")
    public ResponseEntity<User> partiallyUpdateUser(@RequestBody User user, @PathVariable String username) {
        return ResponseEntity.ok(userService.partiallyUpdateUser(user, username));
    }


    @DeleteMapping("/{username}")
    public ResponseEntity<String> deleteUser( @PathVariable String username) {
        userService.deleteUser(username);
        return ResponseEntity.ok("User has been deleted");
    }
}
