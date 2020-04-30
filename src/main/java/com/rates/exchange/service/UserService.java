package com.rates.exchange.service;

import com.rates.exchange.model.User;
import com.rates.exchange.repository.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder ;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public String saveUser(@NotNull User user) {
        if (userRepository
                .findByUsername(user.getUsername()) != null){
            return "USER EXISTS";
        }
        if (userRepository
                .findByEmail(user.getEmail()) != null){
            return "EMAIL IS ALREADY USED";
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "OK";
    }

    public String editUser(String username, String password){
        User user = findUserByUsername(username);

        if (password != null && !password.equals("")) {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return "OK";
        } else return "INVALID PASSWORD";
    }

}
