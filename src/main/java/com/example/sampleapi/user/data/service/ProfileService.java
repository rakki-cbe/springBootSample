package com.example.sampleapi.user.data.service;

import com.example.sampleapi.user.data.model.Profile;
import com.example.sampleapi.user.data.repo.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

     public List<Profile> getAllUser(){
        return profileRepository.findAll();

     }

     public Profile saveProfile(Profile userData){
         return profileRepository.save(userData);
     }
}
