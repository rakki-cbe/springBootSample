package com.example.sampleapi.user.data.repo;

import com.example.sampleapi.user.data.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserData,Long> {
}
