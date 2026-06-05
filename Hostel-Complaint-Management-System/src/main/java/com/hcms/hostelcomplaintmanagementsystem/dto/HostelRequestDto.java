package com.hcms.hostelcomplaintmanagementsystem.dto;

import jakarta.validation.constraints.NotBlank;

public class HostelRequestDto {

    @NotBlank(message = "Name of the hostel is required")
    private String name;

    @NotBlank(message = " Address of the hostel is required")
    private String address;

    @NotBlank(message = "warden id is required")
    private String wardenId;

}
