package com.eq.epharma.dto;

public class AuthenticationReqDto {
    private String username;
    private String userPassword;

    public AuthenticationReqDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
