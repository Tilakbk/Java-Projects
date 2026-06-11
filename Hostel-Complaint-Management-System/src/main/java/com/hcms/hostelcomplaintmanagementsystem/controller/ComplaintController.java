package com.hcms.hostelcomplaintmanagementsystem.controller;

import com.hcms.hostelcomplaintmanagementsystem.dto.ComplaintAssignResponseDto;
import com.hcms.hostelcomplaintmanagementsystem.dto.ComplaintRequestDto;
import com.hcms.hostelcomplaintmanagementsystem.dto.ComplaintResponseDto;
import com.hcms.hostelcomplaintmanagementsystem.service.ComplaintService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ComplaintController {

    private final ComplaintService complaintService;

    public ComplaintController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

    @PostMapping("/complaint")
    public ResponseEntity<ComplaintResponseDto> addComplaint(@Validated @RequestBody ComplaintRequestDto complaintRequestDto)
    {
        return ResponseEntity.ok(complaintService.addComplaint(complaintRequestDto));
    }

    @GetMapping("/complaint")
    public ResponseEntity<List<ComplaintResponseDto>> getAllComplaint()
    {
        return ResponseEntity.ok(complaintService.getAllComplaint());
    }

    @GetMapping("/complaint/{id}")
    public ResponseEntity<ComplaintResponseDto> getComplaintById(@PathVariable UUID id)
    {
        return ResponseEntity.ok(complaintService.getComplaintById(id));
    }

    @GetMapping("/complaint/status/{status}")
    public ResponseEntity<List<ComplaintResponseDto>> getComplaintByStatus(@PathVariable String status)
    {
        return ResponseEntity.ok(complaintService.getComplaintByStatus(status));
    }

    @GetMapping("/complaint/student/{studentId}")
    public ResponseEntity<List<ComplaintResponseDto>> getComplaintByStudent(@PathVariable UUID studentId)
    {
        return ResponseEntity.ok(complaintService.getComplaintByStudent(studentId));
    }

    @PutMapping("/complaint/{id}")
    public ResponseEntity<ComplaintResponseDto> updateComplaint(@PathVariable UUID id,@RequestBody ComplaintRequestDto complaintRequestDto)
    {
        return ResponseEntity.ok(complaintService.updateComplaint(id,complaintRequestDto));
    }

    @DeleteMapping("/complaint/{id}")
    public ResponseEntity<String> deleteComplaint(@PathVariable UUID id)
    {
        complaintService.deleteComplaint(id);
        return ResponseEntity.ok("Deleted successfully");
    }

    @PutMapping("/complaint/{complaintId}/staff/{staffId}")
    public ResponseEntity<ComplaintAssignResponseDto> assignStaffToComplaint(@PathVariable UUID complaintId, @PathVariable UUID staffId)
    {
        return ResponseEntity.ok(complaintService.assignStaffToComplaint(complaintId,staffId));
    }

    @GetMapping("/complaint/staff/{staffId}")
    public ResponseEntity<List<ComplaintResponseDto>> getComplaintByStaff(@PathVariable UUID staffId)
    {
        return ResponseEntity.ok(complaintService.getComplaintByStaff(staffId));
    }

    @PutMapping("/complaint/{id}/resolve")
    public ResponseEntity<ComplaintResponseDto> markComplaintResolved(@PathVariable UUID id,@RequestParam String actionTaken, @RequestParam UUID staffId)
    {
        return ResponseEntity.ok(complaintService.markComplaintResolved(id,actionTaken,staffId));
    }

}
