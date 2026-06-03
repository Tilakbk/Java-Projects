package com.hcms.hostelcomplaintmanagementsystem.mapper;

import com.hcms.hostelcomplaintmanagementsystem.dto.StudentResponseDto;
import com.hcms.hostelcomplaintmanagementsystem.model.Student;

public class Mapper {

    public static StudentResponseDto toStudentResponseDto(Student student)
    {
        StudentResponseDto studentResponseDto= new StudentResponseDto();

        studentResponseDto.setName(student.getName());
        studentResponseDto.setEmail(student.getEmail());
        studentResponseDto.setPhone(student.getPhone());
        studentResponseDto.setRoom_number(student.getRoom().getRoom_number());
        studentResponseDto.setHostel_name(student.getHostel().getName());

        return studentResponseDto;

    }

}
