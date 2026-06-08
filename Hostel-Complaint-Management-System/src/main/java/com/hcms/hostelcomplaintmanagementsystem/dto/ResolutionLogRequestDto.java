package com.hcms.hostelcomplaintmanagementsystem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class ResolutionLogRequestDto {

    @NotNull(message = "Complaint id is required")
    private UUID complaintId;

    @NotNull(message = "Staff id is required")
    private UUID staffId;

    @NotBlank(message = "Action is required")
    private String actionTaken;


}
