package com.hcms.hostelcomplaintmanagementsystem.controller;

import com.hcms.hostelcomplaintmanagementsystem.dto.RoomRequestDto;
import com.hcms.hostelcomplaintmanagementsystem.dto.RoomResponseDto;
import com.hcms.hostelcomplaintmanagementsystem.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
