package com.hcms.hostelcomplaintmanagementsystem.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class StudentPatchDto {
    private String name;
    private String email;
    private String phone;
    private UUID room_id;
    private UUID hostel_id;
}
