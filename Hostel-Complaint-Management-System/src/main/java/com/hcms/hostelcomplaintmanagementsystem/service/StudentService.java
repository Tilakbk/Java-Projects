package com.hcms.hostelcomplaintmanagementsystem.service;

import com.hcms.hostelcomplaintmanagementsystem.dto.StudentRequestDto;
import com.hcms.hostelcomplaintmanagementsystem.dto.StudentResponseDto;
import com.hcms.hostelcomplaintmanagementsystem.mapper.Mapper;
import com.hcms.hostelcomplaintmanagementsystem.model.Student;
import com.hcms.hostelcomplaintmanagementsystem.repository.HostelRepo;
import com.hcms.hostelcomplaintmanagementsystem.repository.RoomRepo;
import com.hcms.hostelcomplaintmanagementsystem.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {

    private final StudentRepo studentRepo;
    private final RoomRepo roomRepo;
    private final HostelRepo hostelRepo;

    public StudentService(StudentRepo studentRepo, RoomRepo roomRepo, HostelRepo hostelRepo)
    {
        this.studentRepo=studentRepo;
        this.roomRepo=roomRepo;
        this.hostelRepo = hostelRepo;
    }


    public List<StudentResponseDto> getAllStudent()
    {
        List<Student> students= studentRepo.findAll();
        return students.stream()
                .map(Mapper::toStudentResponseDto)
                .toList();

    }

    public StudentResponseDto addStudent(StudentRequestDto studentRequestDto) {

        Student student= Mapper.toStudent(studentRequestDto);
        student.setRoom(roomRepo.findById(studentRequestDto.getRoom_id()).orElse(null));
        student.setHostel(hostelRepo.findById(studentRequestDto.getHostel_id()).orElse(null));

        return Mapper.toStudentResponseDto(studentRepo.save(student));

    }
}
