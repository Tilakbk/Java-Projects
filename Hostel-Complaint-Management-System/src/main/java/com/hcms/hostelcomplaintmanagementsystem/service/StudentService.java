package com.hcms.hostelcomplaintmanagementsystem.service;

import com.hcms.hostelcomplaintmanagementsystem.dto.StudentRequestDto;
import com.hcms.hostelcomplaintmanagementsystem.dto.StudentResponseDto;
import com.hcms.hostelcomplaintmanagementsystem.mapper.Mapper;
import com.hcms.hostelcomplaintmanagementsystem.model.Student;
import com.hcms.hostelcomplaintmanagementsystem.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {

    private final StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo)
    {
        this.studentRepo=studentRepo;
    }

    public List<StudentResponseDto> getAllStudent()
    {
        List<Student> students= studentRepo.findAll();
        Map<String,String> response = new HashMap<>();
        return students.stream()
                .map(Mapper::toStudentResponseDto)
                .toList();

    }

    public StudentResponseDto addStudent(StudentRequestDto studentRequestDto) {



    }
}
