package com.example.backend.controller.user;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.backend.dto.user.UpdateProfileDto;
import com.example.backend.dto.user.ProfileSignUpDto;
import com.example.backend.service.user.ProfileService;

@RestController
@RequestMapping("/user/")
public class ProfileController {
    private final ProfileService service;

    public ProfileController(ProfileService service){
        this.service=service;
    }

    @PostMapping("signUp")
    public ResponseEntity<Map<String,Object>> signUp(@RequestBody ProfileSignUpDto profileSignUpDto, @AuthenticationPrincipal Jwt jwt) {
        if (jwt == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Missing token"));
        }

        boolean created = service.createProfile(profileSignUpDto,jwt.getSubject());
        if(created){
            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("message","Profile created Succesfully","email",profileSignUpDto.getEmail()));
        }else{
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("message","Profile already exist","subject",profileSignUpDto.getEmail()));
        }
    }
    
    @PatchMapping("update-profile/{user_id}")
    public ResponseEntity<Map<String,Object>> updateProfile(@PathVariable String user_id,@RequestBody UpdateProfileDto profileDto){
        UpdateProfileDto newProfile = service.updateProfile(user_id,profileDto);
        return ResponseEntity.ok().
                body(Map.of("message","Profile Updated",
                "data",newProfile,"success",true));
    } 

    @GetMapping("get-profile/{user_id}")
    public ResponseEntity<Map<String,Object>> getProfile(@PathVariable String user_id){
        UpdateProfileDto user = service.getPofile(user_id);
        return ResponseEntity.ok().
        body(Map.of("message","User found",
                    "data",user,"success",true));
    }
}
