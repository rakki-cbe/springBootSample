package com.example.sampleapi.user.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "`PROFILE`")
public class Profile {

    @Id
    @GeneratedValue
    public Long profileId;
    public String companyName;
    public String address;
    public String phoneNumber;
    public String email;
    public String gst;
    public String bankName;
    public String accountNumber;
    public String ifsc;
}