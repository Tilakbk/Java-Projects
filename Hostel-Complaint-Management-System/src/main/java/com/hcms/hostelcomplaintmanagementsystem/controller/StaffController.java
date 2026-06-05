package com.hcms.hostelcomplaintmanagementsystem.controller;

import com.hcms.hostelcomplaintmanagementsystem.dto.StaffPatchRequestDto;
import com.hcms.hostelcomplaintmanagementsystem.dto.StaffRequestDto;
import com.hcms.hostelcomplaintmanagementsystem.dto.StaffResponseDto;
import com.hcms.hostelcomplaintmanagementsystem.service.StaffService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class StaffController {

    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping("/staff")
    public ResponseEntity<List<StaffResponseDto>> getAllStaff()
    {
        return ResponseEntity.ok().body(staffService.getAllStaff());
    }

    @PostMapping("/staff")
    public ResponseEntity<StaffResponseDto> addStaff(@Validated @RequestBody StaffRequestDto staffRequestDto)
    {
        return ResponseEntity.ok().body(staffService.addStaff(staffRequestDto));
    }

    @GetMapping("/staff/{id}")
    public ResponseEntity<StaffResponseDto> getStaffById(@PathVariable UUID id)
    {
        return ResponseEntity.ok(staffService.getStaffById(id));
    }

    @GetMapping("/staff/role/{role}")
    public ResponseEntity<List<StaffResponseDto>> getStaffByRole(@PathVariable String role)
    {
        return ResponseEntity.ok(staffService.getStaffByRole(role));
    }

    @PutMapping("/staff/{id}")
    public ResponseEntity<StaffResponseDto> updateStaffById(@PathVariable UUID id, @Validated @RequestBody StaffRequestDto staffRequestDto)
    {
        return ResponseEntity.ok(staffService.updateStaffById(id,staffRequestDto));
    }

    @PatchMapping("/staff/{id}")
    public ResponseEntity<StaffResponseDto> partiallyUpdateStaffById(@PathVariable UUID id, @Validated @RequestBody StaffPatchRequestDto staffPatchRequestDto)
    {
        return ResponseEntity.ok(staffService.partiallyUpdateStaffById(id,staffPatchRequestDto));
    }



}
