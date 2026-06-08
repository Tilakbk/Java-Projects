package com.hcms.hostelcomplaintmanagementsystem.service;

import com.hcms.hostelcomplaintmanagementsystem.dto.ResolutionLogRequestDto;
import com.hcms.hostelcomplaintmanagementsystem.dto.ResolutionLogResponseDto;
import com.hcms.hostelcomplaintmanagementsystem.exceptionhandling.ComplaintNotFoundException;
import com.hcms.hostelcomplaintmanagementsystem.exceptionhandling.StaffNotValidException;
import com.hcms.hostelcomplaintmanagementsystem.mapper.Mapper;
import com.hcms.hostelcomplaintmanagementsystem.model.ResolutionLog;
import com.hcms.hostelcomplaintmanagementsystem.repository.ComplaintRepo;
import com.hcms.hostelcomplaintmanagementsystem.repository.ResolutionLogRepo;
import com.hcms.hostelcomplaintmanagementsystem.repository.StaffRepo;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ResolutionLogService {

    private final ResolutionLogRepo resolutionLogRepo;
    private final ComplaintRepo complaintRepo;
    private final StaffRepo staffRepo;

    public ResolutionLogService(ResolutionLogRepo resolutionLogRepo, ComplaintRepo complaintRepo, StaffRepo staffRepo) {
        this.resolutionLogRepo = resolutionLogRepo;
        this.complaintRepo = complaintRepo;
        this.staffRepo = staffRepo;
    }

    public ResolutionLogResponseDto addResolutionLog(@Valid ResolutionLogRequestDto resolutionLogRequestDto) {

        ResolutionLog resolutionLog= Mapper.toResolutionLog(resolutionLogRequestDto);
        resolutionLog.setComplaint(complaintRepo.findById(resolutionLogRequestDto.getComplaintId()).orElseThrow(()->new ComplaintNotFoundException(resolutionLogRequestDto.getComplaintId()+" Complaint with this id does not exists")));
        resolutionLog.setStaff(staffRepo.findById(resolutionLogRequestDto.getStaffId()).orElseThrow(()-> new StaffNotValidException(resolutionLogRequestDto.getStaffId()+" Staff with this id does not exists ")));

        return Mapper.toResolutionResponseDto(resolutionLogRepo.save(resolutionLog));


    }

    public List<ResolutionLogResponseDto> getAllResolutionLog() {

        List<ResolutionLog> resolutionLog= resolutionLogRepo.findAll();

       return resolutionLog.stream()
                .map(Mapper::toResolutionResponseDto)
                .toList();
    }

    public ResolutionLogResponseDto getResolutionLogById(UUID id) {

        ResolutionLog resolutionLog= resolutionLogRepo.findById(id).orElseThrow(()->new ResolutionLogNotValidException(id+" Resolution log with this id does not exist"));

    }
}
