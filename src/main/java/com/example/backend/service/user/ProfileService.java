package com.example.backend.service.user;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.backend.dto.user.ProfileSignUpDto;
import com.example.backend.dto.user.UpdateProfileDto;
import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.mapper.UpdateProfileMapper;
import com.example.backend.model.user.ProfileModel;
import com.example.backend.repository.user.ProfileRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProfileService {
    
    private final ProfileRepo repo;
    private final UpdateProfileMapper mapper;
    public ProfileService(ProfileRepo repo,UpdateProfileMapper mapper){
        this.repo=repo;
        this.mapper = mapper;
    }

    /**
     * Updates an existing user profile with the provided details.
     * <p>
     * This method is invoked from the user dashboard controller endpoint:
     * <b>PUT /user/update-profile</b>.
     * It first retrieves the profile by the given {@code userId}. If no profile
     * exists, a {@link com.example.backend.exception.ResourceNotFoundException}
     * is thrown. Otherwise, it maps the fields from the incoming
     * {@link UpdateProfileDto} onto the existing {@link ProfileModel}
     * and saves the updated entity in the database.
     *
     * @param userId      the unique identifier of the user whose profile should be updated
     * @param profileDto  the new profile details provided by the user
     * @throws com.example.backend.exception.ResourceNotFoundException
     *         if no profile is found for the given {@code userId}
     */
    public UpdateProfileDto updateProfile(String userId, UpdateProfileDto profileDto) {
        ProfileModel existingProfile = repo.findByUserId(userId).
        orElseThrow(() -> new ResourceNotFoundException(userId));

        mapper.toEntity(profileDto, existingProfile);
        repo.save(existingProfile);
        return mapper.toDto(existingProfile);
    }
    
    /**
     * Creates a new user profile during the signup process.
     * <p>
     * This method is invoked from the signup controller endpoint:
     * <b>POST /user/signUp</b>.
     * It first checks whether a profile already exists for the given subject (userId).
     * If a profile is found, it returns {@code false}, indicating the signup cannot proceed
     * due to a conflict. Otherwise, it creates a new {@link ProfileModel} entity,
     * populates it with the provided details from {@link ProfileSignUpDto},
     * persists it in the database, and returns {@code true}.
     *
     * @param profileSignUpDto the DTO containing the user's signup information (e.g. email)
     * @param subject          the unique identifier of the user (e.g. from authentication token)
     * @return {@code true} if the profile was created successfully,
     *         {@code false} if a profile with the given subject already exists
     */
    public boolean createProfile(ProfileSignUpDto profileSignUpDto,String subject){
        if(repo.findByUserId(subject).isPresent()){
            return false;
        }
        ProfileModel profile = new ProfileModel();
        profile.setUserId(subject);
        profile.setEmail(profileSignUpDto.getEmail());

        repo.save(profile);
        return true;
    }

    public UpdateProfileDto getPofile(String user_id){
        Optional<ProfileModel> user = repo.findByUserId(user_id);
        if(!user.isPresent()){
            throw new ResourceNotFoundException(user_id);
        }

        UpdateProfileDto temp = mapper.toDto(user.get());

        return temp;
    }
}
