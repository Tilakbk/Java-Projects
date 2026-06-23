package com.hcms.hostelcomplaintmanagementsystem.controller;

import com.hcms.hostelcomplaintmanagementsystem.dto.StaffPatchRequestDto;
import com.hcms.hostelcomplaintmanagementsystem.dto.StaffRequestDto;
import com.hcms.hostelcomplaintmanagementsystem.dto.StaffResponseDto;
import com.hcms.hostelcomplaintmanagementsystem.service.StaffService;
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
public class StaffController {

    private final StaffService staffService;

    @GetMapping("/staff")
    @PreAuthorize("hasAnyRole('WARDEN', 'SYSTEM_ADMIN')")
    public ResponseEntity<List<StaffResponseDto>> getAllStaff()
    {
        return ResponseEntity.ok().body(staffService.getAllStaff());
    }

    @PostMapping("/staff")
    @PreAuthorize("hasRole('WARDEN')")
    public ResponseEntity<StaffResponseDto> addStaff(@Validated @RequestBody StaffRequestDto staffRequestDto)
    {
        return ResponseEntity.ok().body(staffService.addStaff(staffRequestDto));
    }

    @GetMapping("/staff/{id}")
    @PreAuthorize("hasAnyRole('WARDEN', 'SYSTEM_ADMIN') or @securityService.isStaffOwner(#id, authentication)")
    public ResponseEntity<StaffResponseDto> getStaffById(@PathVariable UUID id)
    {
        return ResponseEntity.ok(staffService.getStaffById(id));
    }

    @GetMapping("/staff/role/{role}")
    @PreAuthorize("hasAnyRole('WARDEN', 'SYSTEM_ADMIN')")
    public ResponseEntity<List<StaffResponseDto>> getStaffByRole(@PathVariable String role)
    {
        return ResponseEntity.ok(staffService.getStaffByRole(role));
    }

    @PutMapping("/staff/{id}")
    @PreAuthorize("hasRole('WARDEN')")
    public ResponseEntity<StaffResponseDto> updateStaffById(@PathVariable UUID id, @Validated @RequestBody StaffRequestDto staffRequestDto)
    {
        return ResponseEntity.ok(staffService.updateStaffById(id,staffRequestDto));
    }

    @PatchMapping("/staff/{id}")
    @PreAuthorize("hasRole('WARDEN')")
    public ResponseEntity<StaffResponseDto> partiallyUpdateStaffById(@PathVariable UUID id, @Validated @RequestBody StaffPatchRequestDto staffPatchRequestDto)
    {
        return ResponseEntity.ok(staffService.partiallyUpdateStaffById(id,staffPatchRequestDto));
    }

    @DeleteMapping("/staff/{id}")
    @PreAuthorize("hasRole('WARDEN')")
    public ResponseEntity<?> deleteStaff(@PathVariable UUID id)
    {
        staffService.deleteStaff(id);
        return ResponseEntity.noContent().build();
    }



}
