package com.hcms.hostelcomplaintmanagementsystem.controller;

import com.hcms.hostelcomplaintmanagementsystem.dto.RoomRequestDto;
import com.hcms.hostelcomplaintmanagementsystem.dto.RoomResponseDto;
import com.hcms.hostelcomplaintmanagementsystem.model.Room;
import com.hcms.hostelcomplaintmanagementsystem.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/room")
    public ResponseEntity<RoomResponseDto> addRoom(@Valid @RequestBody RoomRequestDto roomRequestDto)
    {
        return ResponseEntity.ok(roomService.addRoom(roomRequestDto));

    }

    @GetMapping("/room")
    public ResponseEntity<List<RoomResponseDto>> getAllRoom()
    {
        return ResponseEntity.ok(roomService.getAllRoom());
    }

    @GetMapping("/room/{id}")
    public ResponseEntity<RoomResponseDto> getRoomById(@PathVariable UUID id)
    {
        return ResponseEntity.ok(roomService.getRoomById(id));
    }

    @GetMapping("/room/hostel/{hostelId}")
    public ResponseEntity<List<RoomResponseDto>> getRoomByHostelId(@PathVariable UUID hostelId)
    {
        return ResponseEntity.ok(roomService.getRoomByHostelId(hostelId));

    }
}
