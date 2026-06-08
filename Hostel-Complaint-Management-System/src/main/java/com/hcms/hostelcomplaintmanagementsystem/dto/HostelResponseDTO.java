package com.hcms.hostelcomplaintmanagementsystem.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class HostelResponseDTO {

    private UUID id;
    private String name;
    private String address;
    private String wardenName;
}
