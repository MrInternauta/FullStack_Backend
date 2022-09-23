package com.mrinternauta.RestApi.domain.dto;

import org.springframework.beans.factory.annotation.Autowired;

public class AuthenticationRequest {
    @Autowired
    private  String email;
    @Autowired
    private  String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
