package com.hcms.hostelcomplaintmanagementsystem.controller;

import com.hcms.hostelcomplaintmanagementsystem.dto.HostelRequestDto;
import com.hcms.hostelcomplaintmanagementsystem.dto.HostelResponseDTO;
import com.hcms.hostelcomplaintmanagementsystem.dto.RoomResponseDto;
import com.hcms.hostelcomplaintmanagementsystem.service.HostelService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class HostelController {

    private final HostelService hostelService;

    public HostelController(HostelService hostelService) {
        this.hostelService = hostelService;
    }

    @GetMapping("/hostel")
    public ResponseEntity<List<HostelResponseDTO>> getAllHostel()
    {
        return ResponseEntity.ok(hostelService.getAllHostel());
    }

    @PostMapping("/hostel")
    public ResponseEntity<HostelResponseDTO> addHostel(@Validated @RequestBody HostelRequestDto hostelRequestDto)
    {
        return ResponseEntity.ok(hostelService.addHostel(hostelRequestDto));
    }

    @GetMapping("/hostel/{id}")
    public ResponseEntity<HostelResponseDTO> getHostelById(@PathVariable UUID id)
    {
        return ResponseEntity.ok(hostelService.getHostelById(id));
    }


    @GetMapping("/hostel/{id}/room")
    public ResponseEntity<List<RoomResponseDto>> getHostelRoomById(@PathVariable UUID id)
    {
        return ResponseEntity.ok(hostelService.getHostelRoomById(id));
    }


}
