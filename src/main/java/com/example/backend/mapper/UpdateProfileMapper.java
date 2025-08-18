package com.example.backend.mapper;

import com.example.backend.dto.user.UpdateProfileDto;
import com.example.backend.model.user.ProfileModel;
import org.springframework.stereotype.Component;

@Component
public class UpdateProfileMapper {

    /**
     * Converts a ProfileModel entity to a ProfileDto.
     *
     * @param profileModel The source ProfileModel object.
     * @return The converted ProfileDto object.
     */
    public UpdateProfileDto toDto(ProfileModel profileModel) {
        if (profileModel == null) {
            return null;
        }

        UpdateProfileDto profileDto = new UpdateProfileDto();
        profileDto.setName(profileModel.getName());
        profileDto.setAge(profileModel.getAge());
        profileDto.setPhone(profileModel.getPhone());
        profileDto.setEmail(profileModel.getEmail());
        profileDto.setAvatar(profileModel.getAvatar());
        profileDto.setDisease(profileModel.getDisease());
        profileDto.setAccessToken(profileModel.getAccessToken());

        return profileDto;
    }

    /**
     * Converts a ProfileDto to a ProfileModel entity.
     *
     * @param profileDto The source ProfileDto object.
     * @return The converted ProfileModel object.
     */
    public ProfileModel toEntity(UpdateProfileDto profileDto,ProfileModel profileModel) {
        if (profileDto == null) {
            return null;
        }
        
        profileModel.setName(profileDto.getName());
        profileModel.setAge(profileDto.getAge());
        profileModel.setPhone(profileDto.getPhone());
        profileModel.setEmail(profileDto.getEmail());
        profileModel.setAvatar(profileDto.getAvatar());
        profileModel.setDisease(profileDto.getDisease());
        profileModel.setAccessToken(profileDto.getAccessToken());
        return profileModel;
    }
}