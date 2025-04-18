package com.example.sampleapi.user.data.repo;

import com.example.sampleapi.user.data.model.CredentialsDataModel;
import com.example.sampleapi.user.data.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialsRepository extends JpaRepository<CredentialsDataModel,Long> {
}
