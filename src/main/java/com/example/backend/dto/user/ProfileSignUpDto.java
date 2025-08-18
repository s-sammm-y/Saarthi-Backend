package com.example.backend.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) used during the user signup process.
 * <p>
 * This DTO represents the minimal data required to create a new profile
 * when a user registers via the <b>POST /user/signUp</b> endpoint.
 * Currently, it only includes the {@code email} field.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProfileSignUpDto {
    String email;
}
