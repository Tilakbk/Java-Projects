package com.hcms.hostelcomplaintmanagementsystem.auth;

import lombok.*;

import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponseDto {

    private String token;
    private String role;
    private String fullName;
    private UUID userId;
}
