package com.hcms.hostelcomplaintmanagementsystem.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class RoomRequestDto {

    @NotNull(message = "room number is a must")
    private int roomNumber;

    @NotNull(message = "Room capacity is a must")
    private int roomCapacity;

    @NotNull(message = "Hostel id is a must")
    private UUID hostelId;

}
