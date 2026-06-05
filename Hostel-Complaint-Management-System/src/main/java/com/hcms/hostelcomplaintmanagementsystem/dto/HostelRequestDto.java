package com.hcms.hostelcomplaintmanagementsystem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class HostelRequestDto {

    @NotBlank(message = "Name of the hostel is required")
    private String name;

    @NotBlank(message = " Address of the hostel is required")
    private String address;

    @NotNull(message = "warden id is required")
    private UUID wardenId;

}
