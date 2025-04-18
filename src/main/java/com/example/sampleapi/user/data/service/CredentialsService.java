package com.example.sampleapi.user.data.service;

import com.example.sampleapi.user.data.model.CredentialsDataModel;
import com.example.sampleapi.user.data.model.Profile;
import com.example.sampleapi.user.data.repo.CredentialsRepository;
import com.example.sampleapi.user.data.repo.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CredentialsService {
    @Autowired
    private CredentialsRepository credentialsRepository;

     public List<CredentialsDataModel> getAllUser(){
        return credentialsRepository.findAll();

     }

     public CredentialsDataModel saveProfile(CredentialsDataModel credentialsDataModel){
         return credentialsRepository.save(credentialsDataModel);
     }
}
