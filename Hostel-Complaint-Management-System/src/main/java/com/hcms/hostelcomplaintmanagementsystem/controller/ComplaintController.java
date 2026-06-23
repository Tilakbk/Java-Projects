package com.hcms.hostelcomplaintmanagementsystem.controller;

import com.hcms.hostelcomplaintmanagementsystem.dto.ComplaintAssignResponseDto;
import com.hcms.hostelcomplaintmanagementsystem.dto.ComplaintRequestDto;
import com.hcms.hostelcomplaintmanagementsystem.dto.ComplaintResponseDto;
import com.hcms.hostelcomplaintmanagementsystem.service.ComplaintService;
import jakarta.validation.Valid;
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
public class ComplaintController {

    private final ComplaintService complaintService;

    @PostMapping("/complaint")
    @PreAuthorize("hasRole('STUDENT')")
    public ResponseEntity<ComplaintResponseDto> addComplaint(@Validated @RequestBody ComplaintRequestDto complaintRequestDto)
    {
        return ResponseEntity.ok(complaintService.addComplaint(complaintRequestDto));
    }

    @GetMapping("/complaint")
    @PreAuthorize("hasAnyRole('WARDEN','SYSTEM_ADMIN')")
    public ResponseEntity<List<ComplaintResponseDto>> getAllComplaint()
    {
        return ResponseEntity.ok(complaintService.getAllComplaint());
    }

    @GetMapping("/complaint/{id}")
    @PreAuthorize("hasAnyRole('WARDEN', 'SYSTEM_ADMIN') or " +
            "@securityService.isComplaintOwner(#id, authentication) or " +
            "@securityService.isAssignedStaff(#id, authentication)")
    public ResponseEntity<ComplaintResponseDto> getComplaintById(@PathVariable UUID id)
    {
        return ResponseEntity.ok(complaintService.getComplaintById(id));
    }

    @GetMapping("/complaint/status/{status}")
    @PreAuthorize("hasAnyRole('WARDEN', 'SYSTEM_ADMIN', 'STAFF')")
    public ResponseEntity<List<ComplaintResponseDto>> getComplaintByStatus(@PathVariable String status)
    {
        return ResponseEntity.ok(complaintService.getComplaintByStatus(status));
    }

    @GetMapping("/complaint/student/{studentId}")
    @PreAuthorize("hasAnyRole('WARDEN', 'SYSTEM_ADMIN') or @securityService.isStudentOwner(#studentId, authentication)")
    public ResponseEntity<List<ComplaintResponseDto>> getComplaintByStudent(@PathVariable UUID studentId)
    {
        return ResponseEntity.ok(complaintService.getComplaintByStudent(studentId));
    }

    @PutMapping("/complaint/{id}")
    @PreAuthorize("hasRole('WARDEN') or @securityService.isComplaintOwner(#id, authentication)")
    public ResponseEntity<ComplaintResponseDto> updateComplaint(@PathVariable UUID id,@RequestBody ComplaintRequestDto complaintRequestDto)
    {
        return ResponseEntity.ok(complaintService.updateComplaint(id,complaintRequestDto));
    }

    @DeleteMapping("/complaint/{id}")
    @PreAuthorize("hasRole('WARDEN')")
    public ResponseEntity<String> deleteComplaint(@PathVariable UUID id)
    {
        complaintService.deleteComplaint(id);
        return ResponseEntity.ok("Deleted successfully");
    }

    @PutMapping("/complaint/{complaintId}/staff/{staffId}")
    @PreAuthorize("hasRole('WARDEN')")
    public ResponseEntity<ComplaintAssignResponseDto> assignStaffToComplaint(@PathVariable UUID complaintId, @PathVariable UUID staffId)
    {
        return ResponseEntity.ok(complaintService.assignStaffToComplaint(complaintId,staffId));
    }

    @GetMapping("/complaint/staff/{staffId}")
    @PreAuthorize("hasRole('WARDEN') or @securityService.isStaffOwner(#staffId, authentication)")
    public ResponseEntity<List<ComplaintResponseDto>> getComplaintByStaff(@PathVariable UUID staffId)
    {
        return ResponseEntity.ok(complaintService.getComplaintByStaff(staffId));
    }

    @PutMapping("/complaint/{id}/resolve")
    @PreAuthorize("hasRole('STAFF') and @securityService.isAssignedStaff(#id, authentication)")
    public ResponseEntity<ComplaintResponseDto> markComplaintResolved(@PathVariable UUID id,@RequestParam String actionTaken, @RequestParam UUID staffId)
    {
        return ResponseEntity.ok(complaintService.markComplaintResolved(id,actionTaken,staffId));
    }

}
