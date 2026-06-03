package com.hcms.hostelcomplaintmanagementsystem.mapper;

import com.hcms.hostelcomplaintmanagementsystem.dto.StudentRequestDto;
import com.hcms.hostelcomplaintmanagementsystem.dto.StudentResponseDto;
import com.hcms.hostelcomplaintmanagementsystem.model.Hostel;
import com.hcms.hostelcomplaintmanagementsystem.model.Student;
import com.hcms.hostelcomplaintmanagementsystem.repository.HostelRepo;
import com.hcms.hostelcomplaintmanagementsystem.repository.RoomRepo;
import com.hcms.hostelcomplaintmanagementsystem.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;

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

    public static Student toStudent(StudentRequestDto studentRequestDto)
    {
        Student student= new Student();

        student.setName(studentRequestDto.getName());
        student.setEmail(studentRequestDto.getEmail());
        student.setPhone(studentRequestDto.getPhone());

    }

}
