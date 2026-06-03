package com.hcms.hostelcomplaintmanagementsystem.controller;

import com.hcms.hostelcomplaintmanagementsystem.dto.StudentResponseDto;
import com.hcms.hostelcomplaintmanagementsystem.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService)
    {
        this.studentService=studentService;
    }

    @GetMapping("/students")
    private ResponseEntity<List<StudentResponseDto>> getAllStudent()
    {

    }
    
}
