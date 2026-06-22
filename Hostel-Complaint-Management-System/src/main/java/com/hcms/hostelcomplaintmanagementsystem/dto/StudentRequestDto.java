package com.hcms.hostelcomplaintmanagementsystem.dto;

import com.hcms.hostelcomplaintmanagementsystem.dto.validator.StudentValidatorGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestDto {

    @NotBlank(message = "This field is required")
    private String name;

    @NotBlank(message = "Email should be unique")
    private String email;

    @NotBlank(message = "Phone is required")
    private String phone;

    @NotBlank
    @Size(min = 8)
    private String password;

    @NotNull(message = "Room id is required",groups = StudentValidatorGroup.class)
    private UUID room_id;

    @NotNull(message = "Hostel id is required",groups = StudentValidatorGroup.class)
    private UUID hostel_id;

}
