package com.eq.epharma.dto;

public class UsersDto {
    private Integer userId;
    private String username;
    private String password;
    private String role;

    public UsersDto(Integer userId, String username, String password, String role) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    @Override public String toString() {
        return "UsersDto [userId=" + userId + ", username=" + username + ", userPassword=" + password
                + ", userRole=" + role + "]";
    }

    public UsersDto() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
