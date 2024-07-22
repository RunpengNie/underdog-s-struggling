package com.TheTroisMousquetaires.Underdogs.Struggling.payload.security;

public class RegisterDto {
    private String email;
    private String userName;
    private String password;

    public RegisterDto() {
    }

    public RegisterDto(String accountOrEmail, String userName, String password) {
        this.email = accountOrEmail;
        this.userName = userName;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String accountOrEmail) {
        this.email = accountOrEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

