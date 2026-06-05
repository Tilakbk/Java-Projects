package com.hcms.hostelcomplaintmanagementsystem.dto;

import lombok.Data;

@Data
public class StaffPatchRequestDto {

    private String name;
    private String role;
    private String phone;
    private String email;
}
