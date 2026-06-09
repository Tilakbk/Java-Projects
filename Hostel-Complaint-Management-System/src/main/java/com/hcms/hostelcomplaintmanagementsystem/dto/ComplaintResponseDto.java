package com.hcms.hostelcomplaintmanagementsystem.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ComplaintResponseDto {

    private UUID complaintId;
    private String StudentName;
    private String categoryName;
    private String description;
    private String status;

}
