package org.example.ctacminispringsecuringapis.model;

import jakarta.persistence.Entity;

@Entity
public class User {
    private String username;
    private String password;
    private String[] roles;
    private String token = null;

    public User(String username, String password, String[] roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String[] getRoles() {
        return roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
