package com.hcms.hostelcomplaintmanagementsystem.service;

import com.hcms.hostelcomplaintmanagementsystem.repository.ResolutionLogRepo;
import org.springframework.stereotype.Service;

@Service
public class ResolutionLogService {

    private final ResolutionLogRepo resolutionLogRepo;

    public ResolutionLogService(ResolutionLogRepo resolutionLogRepo) {
        this.resolutionLogRepo = resolutionLogRepo;
    }
}
