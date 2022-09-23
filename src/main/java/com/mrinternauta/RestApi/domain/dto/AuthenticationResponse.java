package com.mrinternauta.RestApi.domain.dto;

public class AuthenticationResponse {
    private String JWT;
    private UserDomain user;

    public AuthenticationResponse(String JWT) {
        this.JWT = JWT;
    }

    public AuthenticationResponse(String JWT, UserDomain user) {
        this.JWT = JWT;
        this.user = user;
    }

    public String getJWT() {
        return JWT;
    }

    public void setJWT(String JWT) {
        this.JWT = JWT;
    }

    public UserDomain getUser() {
        return user;
    }

    public void setUser(UserDomain user) {
        this.user = user;
    }
}
