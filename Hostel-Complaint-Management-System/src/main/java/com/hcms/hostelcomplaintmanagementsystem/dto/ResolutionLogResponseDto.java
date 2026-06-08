package com.hcms.hostelcomplaintmanagementsystem.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ResolutionLogResponseDto {

    private UUID resolutionLogId;
    private String complaint;
    private String staffName;
    private String actionTaken;
}
