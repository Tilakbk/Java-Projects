package com.hcms.hostelcomplaintmanagementsystem.service;

import com.hcms.hostelcomplaintmanagementsystem.dto.ComplaintRequestDto;
import com.hcms.hostelcomplaintmanagementsystem.dto.ComplaintResponseDto;
import com.hcms.hostelcomplaintmanagementsystem.exceptionhandling.CategoryNotValidException;
import com.hcms.hostelcomplaintmanagementsystem.exceptionhandling.ComplaintNotFoundException;
import com.hcms.hostelcomplaintmanagementsystem.exceptionhandling.StudentNotValidException;
import com.hcms.hostelcomplaintmanagementsystem.mapper.Mapper;
import com.hcms.hostelcomplaintmanagementsystem.model.Complaint;
import com.hcms.hostelcomplaintmanagementsystem.repository.CategoryRepo;
import com.hcms.hostelcomplaintmanagementsystem.repository.ComplaintRepo;
import com.hcms.hostelcomplaintmanagementsystem.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ComplaintService {
    
    private final ComplaintRepo complaintRepo;
    private final StudentRepo studentRepo;
    private final CategoryRepo categoryRepo;

    public ComplaintService(ComplaintRepo complaintRepo, StudentRepo studentRepo, CategoryRepo categoryRepo) {
        this.complaintRepo = complaintRepo;
        this.studentRepo = studentRepo;
        this.categoryRepo = categoryRepo;
    }

    public ComplaintResponseDto addComplaint(ComplaintRequestDto complaintRequestDto) {

        Complaint complaint= Mapper.toComplaint(complaintRequestDto);
        var student= studentRepo.findByName(complaintRequestDto.getStudentName());
        if (student==null)
        {
            throw new StudentNotValidException(complaintRequestDto.getStudentName()+" Student with this name does not exist");
        }
        else
            complaint.setStudent(student);

        var category= categoryRepo.findByCategoryName(complaintRequestDto.getCategoryName());

        if (category==null)
        {
            throw new CategoryNotValidException(complaintRequestDto.getCategoryName()+" Category with this name does not exist");
        }

        else
            complaint.setCategory(category);

        complaint.setStatus("pending");

        return Mapper.toComplaintResponseDto(complaintRepo.save(complaint));

    }

    public List<ComplaintResponseDto> getAllComplaint() {

        List<Complaint> complaints= complaintRepo.findAll();

        return complaints.stream()
                .map(Mapper::toComplaintResponseDto)
                .toList();

    }

    public ComplaintResponseDto getComplaintById(UUID id) {

        Complaint complaint= complaintRepo.findById(id).orElseThrow(()->new ComplaintNotFoundException(id+" : Complaint with this id does not exist"));

        return Mapper.toComplaintResponseDto(complaint);

    }
}
