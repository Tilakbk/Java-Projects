package com.hcms.hostelcomplaintmanagementsystem.controller;

import com.hcms.hostelcomplaintmanagementsystem.dto.ComplaintRequestDto;
import com.hcms.hostelcomplaintmanagementsystem.dto.ComplaintResponseDto;
import com.hcms.hostelcomplaintmanagementsystem.service.ComplaintService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

}
