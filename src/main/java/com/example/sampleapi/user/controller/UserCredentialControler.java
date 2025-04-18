package com.example.sampleapi.user.controller;

import com.example.sampleapi.user.data.model.CredentialsDataModel;
import com.example.sampleapi.user.data.model.Profile;
import com.example.sampleapi.user.data.service.CredentialsService;
import com.example.sampleapi.user.data.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserCredentialControler {
    @Autowired
    private CredentialsService credentialsService;
    @GetMapping("/get")
    public List<CredentialsDataModel> greetings(@RequestParam String companyName){
       return credentialsService.getAllUser();
    }

    @PostMapping("/create")
    public CredentialsDataModel createProfile(@RequestBody CredentialsDataModel credentialsDataModel){
       return credentialsService.saveProfile(credentialsDataModel);
    }
}
