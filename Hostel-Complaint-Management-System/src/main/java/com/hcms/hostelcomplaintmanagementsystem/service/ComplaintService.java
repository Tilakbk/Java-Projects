package com.hcms.hostelcomplaintmanagementsystem.service;

import com.hcms.hostelcomplaintmanagementsystem.dto.ComplaintRequestDto;
import com.hcms.hostelcomplaintmanagementsystem.repository.ComplaintRepo;
import org.springframework.stereotype.Service;

@Service
public class ComplaintService {
    
    private final ComplaintRepo complaintRepo;

    public ComplaintService(ComplaintRepo complaintRepo) {
        this.complaintRepo = complaintRepo;
    }


    public ComplaintResponseDto addComplaint(ComplaintRequestDto complaintRequestDto) {
        return null;
    }
}
