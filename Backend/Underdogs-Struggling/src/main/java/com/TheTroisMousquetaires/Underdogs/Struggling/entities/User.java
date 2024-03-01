package com.TheTroisMousquetaires.Underdogs.Struggling.entities;

import jakarta.persistence.*;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userID;

    @Column(name="user_name")
    private String userName;

    @JoinColumn(name="role")
    @ManyToOne
    private Role role;

    @Column(name="email")
    public String email;

    @Column(name="registration_date")
    private ZonedDateTime registrationDate;

    public User() {
    }

    public User(long userId, String email, String userName, Role role) {
        this.userID = userId;
        this.email = email;
        this.userName = userName;
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

    // Need to add password and integrate Spring Security
}
