package com.hcms.hostelcomplaintmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestDto {

    private String name;
    private String email;
    private String phone;
    private UUID room_id;
    private UUID hostel_id;

}
