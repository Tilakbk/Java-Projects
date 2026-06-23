package com.hcms.hostelcomplaintmanagementsystem.controller;

import com.hcms.hostelcomplaintmanagementsystem.dto.HostelRequestDto;
import com.hcms.hostelcomplaintmanagementsystem.dto.HostelResponseDTO;
import com.hcms.hostelcomplaintmanagementsystem.dto.RoomResponseDto;
import com.hcms.hostelcomplaintmanagementsystem.service.HostelService;
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
public class HostelController {

    private final HostelService hostelService;



    @GetMapping("/hostel")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<HostelResponseDTO>> getAllHostel()
    {
        return ResponseEntity.ok(hostelService.getAllHostel());
    }

    @PostMapping("/hostel")
    @PreAuthorize("hasRole('SYSTEM_ADMIN')")
    public ResponseEntity<HostelResponseDTO> addHostel(@Validated @RequestBody HostelRequestDto hostelRequestDto)
    {
        return ResponseEntity.ok(hostelService.addHostel(hostelRequestDto));
    }

    @GetMapping("/hostel/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<HostelResponseDTO> getHostelById(@PathVariable UUID id)
    {
        return ResponseEntity.ok(hostelService.getHostelById(id));
    }


    @GetMapping("/hostel/{id}/room")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<RoomResponseDto>> getHostelRoomById(@PathVariable UUID id)
    {
        return ResponseEntity.ok(hostelService.getHostelRoomById(id));
    }

    @PutMapping("/hostel/{id}")
    @PreAuthorize("hasRole('SYSTEM_ADMIN')")
    public ResponseEntity<HostelResponseDTO> updateHostel( @RequestBody HostelRequestDto hostelRequestDto, @PathVariable UUID id)
    {
        return ResponseEntity.ok(hostelService.updateHostel(hostelRequestDto,id));
    }

    @DeleteMapping("/hostel/{id}")
    @PreAuthorize("hasRole('SYSTEM_ADMIN')")
    public ResponseEntity<?> deleteHostel(@PathVariable UUID id)
    {
        hostelService.deleteHostel(id);
        return ResponseEntity.ok("Deleted successfully");
    }


}
