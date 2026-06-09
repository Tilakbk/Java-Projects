package com.hcms.hostelcomplaintmanagementsystem.controller;

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

}
