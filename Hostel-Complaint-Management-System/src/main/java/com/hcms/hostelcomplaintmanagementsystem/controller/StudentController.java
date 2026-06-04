package com.hcms.hostelcomplaintmanagementsystem.controller;

import com.hcms.hostelcomplaintmanagementsystem.dto.StudentPatchDto;
import com.hcms.hostelcomplaintmanagementsystem.dto.StudentRequestDto;
import com.hcms.hostelcomplaintmanagementsystem.dto.StudentResponseDto;
import com.hcms.hostelcomplaintmanagementsystem.dto.validator.StudentValidatorGroup;
import com.hcms.hostelcomplaintmanagementsystem.service.StudentService;
import jakarta.validation.groups.Default;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService)
    {
        this.studentService=studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<List<StudentResponseDto>> getAllStudent()
    {
        return ResponseEntity.ok().body(studentService.getAllStudent());
    }

    @PostMapping("/students")
    public ResponseEntity<StudentResponseDto> addStudent( @Validated({Default.class, StudentValidatorGroup.class}) @RequestBody StudentRequestDto studentRequestDto)
    {
        return ResponseEntity.ok().body(studentService.addStudent(studentRequestDto));
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentResponseDto> getStudentById(@PathVariable UUID id)
    {
        return ResponseEntity.ok().body(studentService.getStudentById(id));
    }


    @PutMapping("/students/{id}")
    public ResponseEntity<StudentResponseDto> updateStudentById(@Validated({Default.class,StudentValidatorGroup.class}) @RequestBody StudentRequestDto studentRequestDto, @PathVariable UUID id)
    {
        return ResponseEntity.ok().body(studentService.updateStudentById(id,studentRequestDto));
    }


    @PatchMapping("/students/{id}")
    public ResponseEntity<StudentResponseDto> partiallyUpdateStudentById(@Validated({Default.class}) @RequestBody StudentPatchDto studentPatchDto, @PathVariable UUID id)
    {
        return ResponseEntity.ok().body(studentService.partiallyUpdateStudentById(id,studentPatchDto));
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<StudentResponseDto> deleteStudentById(@PathVariable UUID id)
    {
        return ResponseEntity.ok().body(studentService.deleteStudentById(id));
    }


}
