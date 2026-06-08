package com.hcms.hostelcomplaintmanagementsystem.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class RoomRequestDto {

    @NotNull(message = "room number is a must")
    @Min(value = 1, message = "Room number must be at least 1")
    private Integer roomNumber;

    @NotNull(message = "Room capacity is a must")
    @Min(value = 1, message = "Capacity must be at least 1")
    @Max(value = 4, message = "Capacity cannot exceed 4")
    private Integer roomCapacity;

    @NotNull(message = "Hostel id is a must")
    private UUID hostelId;

}
