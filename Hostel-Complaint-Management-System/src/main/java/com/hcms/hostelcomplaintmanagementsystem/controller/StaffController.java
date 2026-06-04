package com.hcms.hostelcomplaintmanagementsystem.controller;

import com.hcms.hostelcomplaintmanagementsystem.dto.StaffRequestDto;
import com.hcms.hostelcomplaintmanagementsystem.dto.StaffResponseDto;
import com.hcms.hostelcomplaintmanagementsystem.service.StaffService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StaffController {

    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping("/staffs")
    public ResponseEntity<List<StaffResponseDto>> getAllStaff()
    {
        return ResponseEntity.ok().body(staffService.getAllStaff());
    }

    @PostMapping("/staffs")
    public ResponseEntity<StaffResponseDto> addStaff(@Validated @RequestBody StaffRequestDto staffRequestDto)
    {
        return ResponseEntity.ok().body(staffService.addStaff(staffRequestDto));
    }

}
