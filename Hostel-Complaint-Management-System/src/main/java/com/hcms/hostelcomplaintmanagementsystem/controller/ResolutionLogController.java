package com.hcms.hostelcomplaintmanagementsystem.controller;

import com.hcms.hostelcomplaintmanagementsystem.dto.ResolutionLogRequestDto;
import com.hcms.hostelcomplaintmanagementsystem.dto.ResolutionLogResponseDto;
import com.hcms.hostelcomplaintmanagementsystem.model.ResolutionLog;
import com.hcms.hostelcomplaintmanagementsystem.service.ResolutionLogService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    }
}
