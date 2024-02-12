package com.TheTroisMousquetaires.Underdogs.Struggling.entities;

import jakarta.persistence.*;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    @Column(name="UserName")
    private String userName;
    @Column(name="Role")
    private Role role;
    @Column(name="Email")
    public String email;
    @Column(name="RegistrationDate")
    private ZonedDateTime registrationDate;

    public User() {
    }

    public User(long userId, String email, String userName, Role role) {
        this.userId = userId;
        this.email = email;
        this.userName = userName;
        this.registrationDate = ZonedDateTime.now(ZoneOffset.UTC);
        this.role = role;
    }
}
