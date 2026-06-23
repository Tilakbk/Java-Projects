package com.hcms.hostelcomplaintmanagementsystem.security;

import com.hcms.hostelcomplaintmanagementsystem.model.Student;
import com.hcms.hostelcomplaintmanagementsystem.repository.ComplaintRepo;
import com.hcms.hostelcomplaintmanagementsystem.repository.ResolutionLogRepo;
import com.hcms.hostelcomplaintmanagementsystem.repository.StaffRepo;
import com.hcms.hostelcomplaintmanagementsystem.repository.StudentRepo;
import com.hcms.hostelcomplaintmanagementsystem.user.UserPrinciple;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service("securityService")
@RequiredArgsConstructor
public class SecurityService {

    private final StudentRepo studentRepo;
    private final StaffRepo staffRepo;
    private final ComplaintRepo complaintRepo;
    private final ResolutionLogRepo resolutionLogRepo;

    public boolean isStudentOwner(UUID studentId, Authentication auth)
    {
        String email= extractEmail(auth);
        return studentRepo.findById(studentId)
                .map(student->student.getEmail().equals(email))
                .orElse(false);
    }

    public boolean isStaffOwner(UUID staffId,Authentication auth)
    {
        String email= extractEmail(auth);

        return staffRepo.findById(staffId)
                .map(staff-> staff.getEmail().equals(email))
                .orElse(false);
    }


    private String extractEmail(Authentication authentication)
    {
        UserPrinciple userPrinciple= (UserPrinciple) authentication.getPrincipal();
        return userPrinciple.getUsername();
    }



}
