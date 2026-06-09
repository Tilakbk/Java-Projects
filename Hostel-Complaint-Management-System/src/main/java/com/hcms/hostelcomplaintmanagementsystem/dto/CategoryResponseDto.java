package com.hcms.hostelcomplaintmanagementsystem.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class CategoryResponseDto {

    private UUID categoryId;
    private String categoryName;
}
