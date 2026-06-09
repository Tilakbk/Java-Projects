package com.hcms.hostelcomplaintmanagementsystem.dto;

import jakarta.validation.constraints.NotBlank;

public class CategoryRequestDto {

    @NotBlank(message = "Name of the category is mandatory")
    private String CategoryName;
}
