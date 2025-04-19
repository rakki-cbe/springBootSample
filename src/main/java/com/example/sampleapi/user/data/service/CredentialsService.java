package com.example.sampleapi.user.data.service;

import com.example.sampleapi.user.data.model.CredentialsDataModel;
import com.example.sampleapi.user.data.repo.CredentialsRepository;
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

    public CredentialsDataModel getUserByName(String name) {
        return credentialsRepository.findByUserName(name)
                .orElseThrow(() -> new RuntimeException("user not found!"));
    }
}
