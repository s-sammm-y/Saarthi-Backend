package com.example.backend.model.user;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "profile")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfileModel {
    
    @Id
    @Column(name = "user_id", columnDefinition = "TEXT", updatable = false, nullable = false)
    private String userId; 

    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age", nullable = true)
    private Integer age;

    @Column(name = "disease")
    private String disease;

    @Column(name="phone",columnDefinition = "TEXT")
    private String phone;

    @Column(name = "email" ,columnDefinition = "TEXT")
    private String email;

    @Column(name = "avatar",columnDefinition = "TEXT")
    private String avatar;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at",nullable =false)
    private LocalDateTime updatedAt;

    @Column(name = "access_token", columnDefinition = "UUID")
    private UUID accessToken;

    @PrePersist
    public void onCreate(){
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
        if(accessToken == null){
            accessToken =UUID.randomUUID();

        }
    }

    @PreUpdate
    public void onUpdate(){
        updatedAt = LocalDateTime.now();
    }
}
