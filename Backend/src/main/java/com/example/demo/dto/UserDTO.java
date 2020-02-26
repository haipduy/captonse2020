package com.example.demo.dto;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.springframework.stereotype.Component;

import java.io.Serializable;

public class UserDTO implements Serializable {

    private String username;
    private String role;
    private String password;

    public UserDTO(String username, String role) {
        this.username = username;
        this.role = role;
    }

    public UserDTO(String username, String role, String password) {
        this.username = username;
        this.role = role;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
