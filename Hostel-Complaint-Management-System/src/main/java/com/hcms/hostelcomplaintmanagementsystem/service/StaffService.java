package com.hcms.hostelcomplaintmanagementsystem.service;

import com.hcms.hostelcomplaintmanagementsystem.dto.StaffPatchRequestDto;
import com.hcms.hostelcomplaintmanagementsystem.dto.StaffRequestDto;
import com.hcms.hostelcomplaintmanagementsystem.dto.StaffResponseDto;
import com.hcms.hostelcomplaintmanagementsystem.exceptionhandling.EmailAlreadyExistsException;
import com.hcms.hostelcomplaintmanagementsystem.exceptionhandling.PhoneAlreadyExistsException;
import com.hcms.hostelcomplaintmanagementsystem.exceptionhandling.StaffNotValidException;
import com.hcms.hostelcomplaintmanagementsystem.exceptionhandling.StudentNotValidException;
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

        Staff staff= staffRepo.findById(id).orElseThrow(()->new StaffNotValidException(id+" This staff does not exist"));

        return Mapper.toStaffResponseDto(staff);

    }

    public List<StaffResponseDto> getStaffByRole(String role) {

        List<Staff> staff= staffRepo.findAllByRole(role);

       return staff.stream()
                .map(Mapper::toStaffResponseDto)
                .toList();
    }

    public StaffResponseDto updateStaffById(UUID id, StaffRequestDto staffRequestDto) {

        Staff staff=staffRepo.findById(id).orElseThrow(()->new StaffNotValidException(id+" This staff does not exist"));

        if (staffRepo.existsByEmailAndStaffIdNot(staffRequestDto.getEmail(),id))
        {
            throw new EmailAlreadyExistsException(staffRequestDto.getEmail()+" This email already exist");
        }
        staff.setName(staffRequestDto.getName());
        staff.setRole(staffRequestDto.getRole());
        staff.setEmail(staffRequestDto.getEmail());
        staff.setPhone(staffRequestDto.getPhone());

        return Mapper.toStaffResponseDto(staffRepo.save(staff));
    }


    public StaffResponseDto partiallyUpdateStaffById(UUID id, StaffPatchRequestDto staffPatchRequestDto) {

        Staff staff=staffRepo.findById(id).orElseThrow(()->new StaffNotValidException(id+" This staff does not exist"));


        if (staffPatchRequestDto.getRole()!=null)
        {
            staff.setRole(staffPatchRequestDto.getRole());

        }

        if (staffPatchRequestDto.getEmail()!=null && staffRepo.existsByEmailAndStaffIdNot(staffPatchRequestDto.getEmail(),id))
        {
            throw new EmailAlreadyExistsException(staffPatchRequestDto.getEmail()+" This email already exist");
        }


        if (staffPatchRequestDto.getEmail()!=null)
        {
            staff.setEmail(staffPatchRequestDto.getEmail());

        }

        if (staffPatchRequestDto.getPhone()!=null && staffRepo.existsByPhoneAndStaffIdNot(staffPatchRequestDto.getPhone(),id))
        {
            throw new PhoneAlreadyExistsException(staffPatchRequestDto.getPhone()+" This phone already exist");
        }


        if (staffPatchRequestDto.getPhone()!=null)
        {
            staff.setPhone(staffPatchRequestDto.getPhone());

        }

        if (staffPatchRequestDto.getName()!=null)
        {
            staff.setName(staffPatchRequestDto.getName());

        }

        return Mapper.toStaffResponseDto(staffRepo.save(staff));





    }

    public void deleteStaff(UUID id) {

        staffRepo.delete(staffRepo.findById(id).orElseThrow(()->new StaffNotValidException(id+" This staff does not exist")));

    }
}
