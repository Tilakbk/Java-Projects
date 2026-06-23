package com.hcms.hostelcomplaintmanagementsystem.controller;

import com.hcms.hostelcomplaintmanagementsystem.dto.ResolutionLogRequestDto;
import com.hcms.hostelcomplaintmanagementsystem.dto.ResolutionLogResponseDto;
import com.hcms.hostelcomplaintmanagementsystem.service.ResolutionLogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ResolutionLogController {

    private final ResolutionLogService resolutionLogService;


    @PostMapping("/resolution-log")
    @PreAuthorize("hasRole('STAFF')")
    public ResponseEntity<ResolutionLogResponseDto> addResolutionLog(@Valid @RequestBody ResolutionLogRequestDto resolutionLogRequestDto)
    {
        return ResponseEntity.ok(resolutionLogService.addResolutionLog(resolutionLogRequestDto));
    }

    @GetMapping("/resolution-log")
    @PreAuthorize("hasAnyRole('WARDEN', 'SYSTEM_ADMIN')")
    public ResponseEntity<List<ResolutionLogResponseDto>> getAllResolutionLog()
    {
        return ResponseEntity.ok(resolutionLogService.getAllResolutionLog());
    }

    @GetMapping("/resolution-log/{id}")
    @PreAuthorize("hasAnyRole('WARDEN', 'SYSTEM_ADMIN') or " +
            "@securityService.isResolutionLogStaff(#id, authentication) or " +
            "@securityService.isResolutionLogComplaintOwner(#id, authentication)")
    public ResponseEntity<ResolutionLogResponseDto> getResolutionLogById(@PathVariable UUID id)
    {
        return ResponseEntity.ok(resolutionLogService.getResolutionLogById(id));
    }

    @GetMapping("/resolution-log/complaint/{complaintId}")
    @PreAuthorize("hasAnyRole('WARDEN', 'SYSTEM_ADMIN') or " +
            "@securityService.isComplaintOwner(#complaintId, authentication) or " +
            "@securityService.isAssignedStaff(#complaintId, authentication)")
    public ResponseEntity<List<ResolutionLogResponseDto>> getResolutionLogByComplaintId(@PathVariable UUID complaintId)
    {
        return ResponseEntity.ok(resolutionLogService.getResolutionLogByComplaintId(complaintId));
    }

    @GetMapping("/resolution-log/staff/{staffId}")
    @PreAuthorize("hasRole('WARDEN') or @securityService.isStaffOwner(#staffId, authentication)")
    public ResponseEntity<List<ResolutionLogResponseDto>> getResolutionLogByStaffId(@PathVariable UUID staffId)
    {
        return ResponseEntity.ok(resolutionLogService.getResolutionLogByStaffId(staffId));
    }

    @PutMapping("/resolution-log/{id}")
    @PreAuthorize("hasRole('STAFF') and @securityService.isResolutionLogStaff(#id, authentication)")
    public ResponseEntity<ResolutionLogResponseDto> updateResolutionLog(@RequestBody ResolutionLogRequestDto resolutionLogRequestDto,@PathVariable UUID id)
    {
        return ResponseEntity.ok(resolutionLogService.updateResolutionLog(resolutionLogRequestDto,id));
    }

    @DeleteMapping("/resolution-log/{id}")
    @PreAuthorize("hasRole('WARDEN')")
    public ResponseEntity<String> deleteResolutionLog(@PathVariable UUID id)
    {
        resolutionLogService.deleteResolutionLog(id);
        return ResponseEntity.ok("Deleted successfully");
    }

}
