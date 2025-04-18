package com.example.sampleapi.user.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "`USERINFO`")
public class CredentialsDataModel {

    @Id
    @GeneratedValue
    Long id;
    public String name;
    public String uerName;
    public String password;
    public String role;
}
