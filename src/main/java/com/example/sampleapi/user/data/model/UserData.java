package com.example.sampleapi.user.data.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name = "USERINFO")
public class UserData {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String uerName;
    private String password;
    private String role;

    // standard constructors

    // standard getters and setters
}

