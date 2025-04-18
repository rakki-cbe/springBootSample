package com.example.sampleapi.user.controller;

import com.example.sampleapi.user.data.model.Profile;
import com.example.sampleapi.user.data.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileControler {
    @Autowired
    private ProfileService profileService;
    @GetMapping("/get")
    public List<Profile> greetings(@RequestParam String companyName){
       return profileService.getAllUser();
    }

    @PostMapping("/create")
    public Profile createProfile(@RequestBody Profile profile){
       return profileService.saveProfile(profile);
    }
}
