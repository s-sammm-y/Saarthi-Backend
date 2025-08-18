package com.example.backend.repository.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.backend.model.user.ProfileModel;

@Repository
public interface ProfileRepo extends JpaRepository<ProfileModel,String> {
    
    Optional<ProfileModel> findByUserId(String user_id);
}
