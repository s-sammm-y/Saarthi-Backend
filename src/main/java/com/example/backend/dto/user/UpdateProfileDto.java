package com.example.backend.dto.user;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This DTO is consumed by the <b>PUT /user/update-profile</b> endpoint
 * and allows updating basic profile attributes such as name, age,
 * phone, email, disease, and avatar.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateProfileDto {
    private String name;
    private Integer age;
    private String phone;
    private String disease;
    private String email;
    private String avatar;
    private UUID accessToken;
}
