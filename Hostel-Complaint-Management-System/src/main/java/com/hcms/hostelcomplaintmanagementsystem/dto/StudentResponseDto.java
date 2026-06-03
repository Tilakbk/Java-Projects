package com.hcms.hostelcomplaintmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponseDto {

    private String name;
    private String email;
    private String phone;
    private int room_number;
    private String hostel_name;
}
