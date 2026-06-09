package com.hcms.hostelcomplaintmanagementsystem.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ComplaintRequestDto {

    @NotBlank(message = "Student name is mandatory")
    private String studentName;

    @NotBlank(message = "category name is mandatory")
    private String categoryName;

    @NotBlank(message = "Description is mandatory")
    private String description;


}
