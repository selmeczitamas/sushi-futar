package com.sushifutar.service;

import com.sushifutar.model.User;
import com.sushifutar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService() {
    }

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User createUser(HashMap<String, String> params) {
        String firstName = params.get("firstname");
        String lastName = params.get("lastname");
        String email = params.get("email");
        String phoneNumber = params.get("phonenumber");
        String password = params.get("password");
        String hashedPassword = getHashedPassword(password);
        User user = new User(firstName, lastName, email, phoneNumber, hashedPassword);
        return user;
    }

    public String getHashedPassword(String password) {
        String hashedPassword = passwordEncoder.bCryptPasswordEncoder.encode(password);
        return hashedPassword;
    }

    public User getUserByEmail(String email) {
        User userByEmail = userRepository.findUserByEmail(email);
        return userByEmail;
    }
}
