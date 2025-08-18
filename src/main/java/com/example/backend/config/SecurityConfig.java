package com.example.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.oauth2.jwt.Jwt;
// import org.springframework.security.oauth2.jwt.JwtDecoder;
// import org.springframework.security.oauth2.jwt.JwtDecoders;
// import org.springframework.security.oauth2.jwt.JwtException;
// import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(csrf -> csrf.disable()).
        authorizeHttpRequests(auth -> auth
        .requestMatchers("/public/**").permitAll()
        .anyRequest().authenticated())
        .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));
        return http.build();
    }

    // @Bean
    // public JwtDecoder jwtDecoder() {
    //     String issuer = "https://nice-badger-70.clerk.accounts.dev";

    //     NimbusJwtDecoder decoder = (NimbusJwtDecoder) JwtDecoders.fromIssuerLocation(issuer);

    //     return token -> {
    //         try {
    //             Jwt jwt = decoder.decode(token);
    //             System.out.println("=== JWT successfully decoded ===");
    //             System.out.println("Header: " + jwt.getHeaders());
    //             System.out.println("Claims: " + jwt.getClaims());
    //             return jwt;
    //         } catch (JwtException e) {
    //             System.err.println("=== JWT DECODING FAILED ===");
    //             System.err.println("Reason: " + e.getMessage());
    //             e.printStackTrace();
    //             throw e;
    //         }
    //     };
    // }
}
