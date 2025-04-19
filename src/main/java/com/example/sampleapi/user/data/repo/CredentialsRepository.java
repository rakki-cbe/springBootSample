package com.example.sampleapi.user.data.repo;

import com.example.sampleapi.user.data.model.CredentialsDataModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CredentialsRepository extends JpaRepository<CredentialsDataModel,Long> {
    Optional<CredentialsDataModel> findByUserName(String username);

    @Query(value = "SELECT * FROM USERINFO WHERE USERNAME = ?1 AND PASSWORD = ?2", nativeQuery = true)
    Optional<CredentialsDataModel> getUserFromUserNameAndPassword(String username,
                                                                  String password);
}
