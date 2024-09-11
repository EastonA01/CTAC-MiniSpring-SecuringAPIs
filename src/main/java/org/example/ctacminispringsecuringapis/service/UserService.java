package org.example.ctacminispringsecuringapis.service;

import org.example.ctacminispringsecuringapis.dto.CredentialsDto;
import org.example.ctacminispringsecuringapis.dto.RegistrationDto;
import org.example.ctacminispringsecuringapis.model.User;
import org.example.ctacminispringsecuringapis.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User login(CredentialsDto credentials) {
        User user = userRepository.findByUsername(credentials.getUsername());
        if (user == null || !user.getPassword().equals(credentials.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        return user;
    }

    public User findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return user; // userMapper.toUserDto(user);
    }

    public User register(RegistrationDto registration) {
        if (userRepository.findByUsername(registration.getUsername()) != null) {
            throw new RuntimeException("Username already exists");
        }

        User user = new User(registration.getUsername(), registration.getPassword(), registration.getRoles());
        userRepository.addUser(user);
        return user;
    }
}