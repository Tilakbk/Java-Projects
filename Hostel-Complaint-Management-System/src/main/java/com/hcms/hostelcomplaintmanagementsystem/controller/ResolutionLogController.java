package com.hcms.hostelcomplaintmanagementsystem.controller;

import com.hcms.hostelcomplaintmanagementsystem.model.ResolutionLog;
import com.hcms.hostelcomplaintmanagementsystem.service.ResolutionLogService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ResolutionLogController {

    private final ResolutionLogService resolutionLogService;

    public ResolutionLogController(ResolutionLogService resolutionLogService) {
        this.resolutionLogService = resolutionLogService;
    }
}
