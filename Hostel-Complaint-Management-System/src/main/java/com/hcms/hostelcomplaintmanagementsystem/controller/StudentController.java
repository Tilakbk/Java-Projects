package com.hcms.hostelcomplaintmanagementsystem.controller;

import com.hcms.hostelcomplaintmanagementsystem.dto.StudentRequestDto;
import com.hcms.hostelcomplaintmanagementsystem.dto.StudentResponseDto;
import com.hcms.hostelcomplaintmanagementsystem.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService)
    {
        this.studentService=studentService;
    }

    @GetMapping("/students")
    private ResponseEntity<List<StudentResponseDto>> getAllStudent()
    {
        return ResponseEntity.ok().body(studentService.getAllStudent());
    }

    @PostMapping("/students")
    private ResponseEntity<StudentResponseDto> addStudent(@RequestBody StudentRequestDto studentRequestDto)
    {
        return ResponseEntity.ok().body(studentService.addStudent(studentRequestDto));
    }

    
}
