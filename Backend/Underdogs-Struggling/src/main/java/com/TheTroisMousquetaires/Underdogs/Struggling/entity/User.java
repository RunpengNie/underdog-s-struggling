package com.TheTroisMousquetaires.Underdogs.Struggling.entity;

import jakarta.persistence.*;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userID;

    @Column(name="user_name", nullable = false)
    private String userName;

    @Column(name="password", nullable = false)
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @Column(name="email")
    private String email;

    @Column(name="registration_date")
    private ZonedDateTime registrationDate;

    public User() {
    }

    public User(long userId, String email, String userName, String password, Role role) {
        this.userID = userId;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.registrationDate = ZonedDateTime.now(ZoneOffset.UTC);
        this.role = role;
    }

    // Getters and Setters
    public long getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ZonedDateTime getRegistrationDate() {
        return registrationDate;
    }
}
