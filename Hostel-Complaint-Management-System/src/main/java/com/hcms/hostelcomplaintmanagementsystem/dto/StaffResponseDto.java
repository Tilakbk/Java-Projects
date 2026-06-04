package com.hcms.hostelcomplaintmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffResponseDto {

    private String name;
    private String role;
    private String email;
    private String phone;


}
