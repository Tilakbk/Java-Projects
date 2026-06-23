package com.hcms.hostelcomplaintmanagementsystem.security;

import com.hcms.hostelcomplaintmanagementsystem.repository.ComplaintRepo;
import com.hcms.hostelcomplaintmanagementsystem.repository.ResolutionLogRepo;
import com.hcms.hostelcomplaintmanagementsystem.repository.StaffRepo;
import com.hcms.hostelcomplaintmanagementsystem.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("securityService")
@RequiredArgsConstructor
public class SecurityService {

    private final StudentRepo studentRepo;
    private final StaffRepo staffRepo;
    private final ComplaintRepo complaintRepo;
    private final ResolutionLogRepo resolutionLogRepo;



}
