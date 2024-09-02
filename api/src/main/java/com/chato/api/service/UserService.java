package com.chato.api.service;



import com.chato.api.entity.AppUser;
import com.chato.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public AppUser createUser(AppUser user) {
        return userRepository.save(user);
    }

    public AppUser loginUser(AppUser user) {
        AppUser existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            return existingUser;
        }
        return null;
    }

    public List<AppUser> getAllUsers() {
        System.out.println("Dans le servuce user dans la méthode getalluser : "+userRepository.findAll());
        return userRepository.findAll();
    }

    public AppUser getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

