package com.TheTroisMousquetaires.Underdogs.Struggling.payload.security;

public class LoginDto {
    private String email;
    private String password;

    public LoginDto() {
    }

    public LoginDto(String accountOrEmail, String password) {
        this.email = accountOrEmail;
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
}
