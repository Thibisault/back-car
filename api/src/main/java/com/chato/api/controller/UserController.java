package com.chato.api.controller;

import com.chato.api.entity.AppUser;
import com.chato.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public AppUser createUser(@RequestBody AppUser user) {
        return userService.createUser(user);
    }

    @GetMapping
    public List<AppUser> getAllUsers() {
        System.out.println("Je suis dans le controller user et dans la méthode getalluser");
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public AppUser getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
    @PostMapping("/login")
    public AppUser loginUser(@RequestBody AppUser user) {
        return userService.loginUser(user);
    }

}
