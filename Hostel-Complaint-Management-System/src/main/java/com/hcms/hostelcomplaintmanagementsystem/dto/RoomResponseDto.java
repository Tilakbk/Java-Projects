package com.hcms.hostelcomplaintmanagementsystem.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class RoomResponseDto {

    private UUID roomId;
    private int roomCapacity;
    private int roomNumber;
}
