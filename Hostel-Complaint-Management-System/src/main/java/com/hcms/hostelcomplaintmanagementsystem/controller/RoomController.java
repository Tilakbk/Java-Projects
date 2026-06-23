package com.hcms.hostelcomplaintmanagementsystem.controller;

import com.hcms.hostelcomplaintmanagementsystem.dto.RoomRequestDto;
import com.hcms.hostelcomplaintmanagementsystem.dto.RoomResponseDto;
import com.hcms.hostelcomplaintmanagementsystem.model.Room;
import com.hcms.hostelcomplaintmanagementsystem.service.RoomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;



    @PostMapping("/room")
    @PreAuthorize("hasRole('WARDEN')")
    public ResponseEntity<RoomResponseDto> addRoom(@Valid @RequestBody RoomRequestDto roomRequestDto)
    {
        return ResponseEntity.ok(roomService.addRoom(roomRequestDto));

    }

    @GetMapping("/room")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<RoomResponseDto>> getAllRoom()
    {
        return ResponseEntity.ok(roomService.getAllRoom());
    }

    @GetMapping("/room/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<RoomResponseDto> getRoomById(@PathVariable UUID id)
    {
        return ResponseEntity.ok(roomService.getRoomById(id));
    }

    @GetMapping("/room/hostel/{hostelId}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<RoomResponseDto>> getRoomByHostelId(@PathVariable UUID hostelId)
    {
        return ResponseEntity.ok(roomService.getRoomByHostelId(hostelId));

    }
}
