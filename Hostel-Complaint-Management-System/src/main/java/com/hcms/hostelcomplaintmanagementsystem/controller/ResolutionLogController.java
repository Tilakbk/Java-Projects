package com.hcms.hostelcomplaintmanagementsystem.controller;

import com.hcms.hostelcomplaintmanagementsystem.dto.ResolutionLogRequestDto;
import com.hcms.hostelcomplaintmanagementsystem.dto.ResolutionLogResponseDto;
import com.hcms.hostelcomplaintmanagementsystem.model.ResolutionLog;
import com.hcms.hostelcomplaintmanagementsystem.service.ResolutionLogService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ResolutionLogController {

    private final ResolutionLogService resolutionLogService;

    public ResolutionLogController(ResolutionLogService resolutionLogService) {
        this.resolutionLogService = resolutionLogService;
    }

    @PostMapping("/resolution-log")
    public ResponseEntity<ResolutionLogResponseDto> addResolutionLog(@Valid @RequestBody ResolutionLogRequestDto resolutionLogRequestDto)
    {
        return ResponseEntity.ok(resolutionLogService.addResolutionLog(resolutionLogRequestDto));
    }

    @GetMapping("/resolution-log")
    public ResponseEntity<List<ResolutionLogResponseDto>> getAllResolutionLog()
    {
        return ResponseEntity.ok(resolutionLogService.getAllResolutionLog());
    }

    @GetMapping("/resolution-log/{id}")
    public ResponseEntity<ResolutionLogResponseDto> getResolutionLogById(@PathVariable UUID id)
    {
        return ResponseEntity.ok(resolutionLogService.getResolutionLogById(id));
    }

    @GetMapping("/resolution-log/complaint/{complaintId}")
    public ResponseEntity<List<ResolutionLogResponseDto>> getResolutionLogByComplaintId(@PathVariable UUID complaintId)
    {
        return ResponseEntity.ok(resolutionLogService.getResolutionLogByComplaintId(complaintId));
    }

    @GetMapping("/resolution-log/staff/{staffId}")
    public ResponseEntity<List<ResolutionLogResponseDto>> getResolutionLogByStaffId(@PathVariable UUID staffId)
    {
        return ResponseEntity.ok(resolutionLogService.getResolutionLogByStaffId(staffId));
    }







}
