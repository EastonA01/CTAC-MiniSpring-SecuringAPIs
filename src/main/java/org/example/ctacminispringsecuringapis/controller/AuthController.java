package org.example.ctacminispringsecuringapis.controller;

import org.example.ctacminispringsecuringapis.dto.CredentialsDto;
import org.example.ctacminispringsecuringapis.dto.RegistrationDto;
import org.example.ctacminispringsecuringapis.model.User;
import org.example.ctacminispringsecuringapis.security.UserAuthProvider;
import org.example.ctacminispringsecuringapis.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final UserService userService;
    private final UserAuthProvider userAuthProvider;

    public AuthController(UserService userService, UserAuthProvider userAuthProvider) {
        this.userService = userService;
        this.userAuthProvider = userAuthProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody CredentialsDto credentials) {
        User user = userService.login(credentials);

        user.setToken(userAuthProvider.createToken(user.getUsername()));
        return ResponseEntity.ok(user);
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegistrationDto registration) {
        User user = userService.register(registration);

        user.setToken(userAuthProvider.createToken(user.getUsername()));
        return ResponseEntity.ok(user);
    }
}
