package com.hcms.hostelcomplaintmanagementsystem.service;

import com.hcms.hostelcomplaintmanagementsystem.dto.StaffRequestDto;
import com.hcms.hostelcomplaintmanagementsystem.dto.StaffResponseDto;
import com.hcms.hostelcomplaintmanagementsystem.exceptionhandling.EmailAlreadyExistsException;
import com.hcms.hostelcomplaintmanagementsystem.exceptionhandling.PhoneAlreadyExistsException;
import com.hcms.hostelcomplaintmanagementsystem.mapper.Mapper;
import com.hcms.hostelcomplaintmanagementsystem.model.Staff;
import com.hcms.hostelcomplaintmanagementsystem.repository.StaffRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StaffService {

    private final StaffRepo staffRepo;

    public StaffService(StaffRepo staffRepo) {
        this.staffRepo = staffRepo;
    }

    public List<StaffResponseDto> getAllStaff() {

        List<Staff> staffs= staffRepo.findAll();

       return staffs.stream()
                .map(Mapper::toStaffResponseDto)
                .toList();

    }

    public StaffResponseDto addStaff(StaffRequestDto staffRequestDto) {

            if (staffRepo.existsByEmail(staffRequestDto.getEmail()))
            {
                throw new EmailAlreadyExistsException(staffRequestDto.getEmail()+" This email already exist");
            }

            if (staffRepo.existsByPhone((staffRequestDto.getPhone())))
            {
                throw new PhoneAlreadyExistsException(staffRequestDto.getPhone()+" This phone already exist");
            }

            Staff staff = staffRepo.save(Mapper.toStaff(staffRequestDto));

            return Mapper.toStaffResponseDto(staff);


    }

    public StaffResponseDto getStaffById(UUID id) {

        Staff staff= staffRepo.findById(id).orElseThrow(new StaffNotValidException(id+" This staff does not exist"));

    }
}
