package com.hcms.hostelcomplaintmanagementsystem.service;

import com.hcms.hostelcomplaintmanagementsystem.dto.ComplaintAssignResponseDto;
import com.hcms.hostelcomplaintmanagementsystem.dto.ComplaintRequestDto;
import com.hcms.hostelcomplaintmanagementsystem.dto.ComplaintResponseDto;
import com.hcms.hostelcomplaintmanagementsystem.exceptionhandling.CategoryNotValidException;
import com.hcms.hostelcomplaintmanagementsystem.exceptionhandling.ComplaintNotFoundException;
import com.hcms.hostelcomplaintmanagementsystem.exceptionhandling.StaffNotValidException;
import com.hcms.hostelcomplaintmanagementsystem.exceptionhandling.StudentNotValidException;
import com.hcms.hostelcomplaintmanagementsystem.mapper.Mapper;
import com.hcms.hostelcomplaintmanagementsystem.model.Complaint;
import com.hcms.hostelcomplaintmanagementsystem.model.ResolutionLog;
import com.hcms.hostelcomplaintmanagementsystem.model.Staff;
import com.hcms.hostelcomplaintmanagementsystem.repository.CategoryRepo;
import com.hcms.hostelcomplaintmanagementsystem.repository.ComplaintRepo;
import com.hcms.hostelcomplaintmanagementsystem.repository.StaffRepo;
import com.hcms.hostelcomplaintmanagementsystem.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ComplaintService {
    
    private final ComplaintRepo complaintRepo;
    private final StudentRepo studentRepo;
    private final CategoryRepo categoryRepo;
    private final StaffRepo staffRepo;

    public ComplaintService(ComplaintRepo complaintRepo, StudentRepo studentRepo, CategoryRepo categoryRepo, StaffRepo staffRepo) {
        this.complaintRepo = complaintRepo;
        this.studentRepo = studentRepo;
        this.categoryRepo = categoryRepo;
        this.staffRepo = staffRepo;
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

    public List<ComplaintResponseDto> getComplaintByStatus(String status) {

       List<Complaint>  complaint= complaintRepo.findAllByStatus(status);

       return complaint.stream()
               .map(Mapper::toComplaintResponseDto)
               .toList();



    }

    public List<ComplaintResponseDto> getComplaintByStudent(UUID studentId) {

        List<Complaint> complaints= studentRepo.findById(studentId).orElseThrow(()->new StudentNotValidException(studentId+" : Student with this id does not exist")).getComplaints();

        return complaints.stream()
                .map(Mapper::toComplaintResponseDto)
                .toList();


    }

    public ComplaintResponseDto updateComplaint(UUID id, ComplaintRequestDto complaintRequestDto) {

        Complaint complaint= complaintRepo.findById(id).orElseThrow(()-> new ComplaintNotFoundException(id+" : Complaint with this id does not exist"));

        if (complaintRequestDto.getStudentName()!=null && studentRepo.existsByName(complaintRequestDto.getStudentName()))
        {
            complaint.setStudent(studentRepo.findByName(complaintRequestDto.getStudentName()));
        }

        if (complaintRequestDto.getCategoryName()!=null && categoryRepo.existsByCategoryName(complaintRequestDto.getCategoryName()))
        {
            complaint.setCategory(categoryRepo.findByCategoryName(complaintRequestDto.getCategoryName()));
        }

        if (complaintRequestDto.getDescription()!=null)
        {
            complaint.setDescription(complaint.getDescription());
        }

        return Mapper.toComplaintResponseDto(complaintRepo.save(complaint));

    }

    public void deleteComplaint(UUID id) {

        Complaint complaint= complaintRepo.findById(id).orElseThrow(()->new ComplaintNotFoundException(id+" : Complaint with this id does not exist"));
        complaintRepo.delete(complaint);

    }

    public ComplaintAssignResponseDto assignStaffToComplaint(UUID complaintId, UUID staffId) {

        Complaint complaint=complaintRepo.findById(complaintId).orElseThrow(()-> new ComplaintNotFoundException(complaintId+" : Complaint with this id does not exist"));

        Staff staff= staffRepo.findById(staffId).orElseThrow(()->new StaffNotValidException(staffId+" : Staff with this id does not exist"));

        complaint.setAssignedStaff(staff);
        complaint.setStatus("in-progress");

        return Mapper.toComplaintAssignResponseDto(complaintRepo.save(complaint));

    }

    public List<ComplaintResponseDto> getComplaintByStaff(UUID staffId) {

        Staff staff= staffRepo.findById(staffId).orElseThrow(()->new StaffNotValidException(staffId+" : Staff with this id does not exist"));

        List<Complaint> complaints= staff.getAssignedComplaint();

        return complaints.stream()
                .map(Mapper::toComplaintResponseDto)
                .toList();

    }

    public ComplaintResponseDto markComplaintResolved(UUID id, String actionTaken, UUID staffId) {

        Complaint complaint= complaintRepo.findById(id).orElseThrow(()-> new ComplaintNotFoundException(id+" : Complaint with this id does not exist"));

        Staff staff= staffRepo.findById(staffId).orElseThrow(()->new StaffNotValidException(staffId+" : Staff with this id does not exist"));

        ResolutionLog log= new ResolutionLog();
        log.setComplaint(complaint);
        log.setStaff(staff);
        log.setActionTaken(actionTaken);
        log.setResolved_at(LocalDateTime.now());

        complaint.getResolutionLogs().add(log);
        complaint.setStatus("Resolved");

        return Mapper.toComplaintResponseDto(complaintRepo.save(complaint));

    }
}
