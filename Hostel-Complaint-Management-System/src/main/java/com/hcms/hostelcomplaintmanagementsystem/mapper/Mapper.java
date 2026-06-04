package com.hcms.hostelcomplaintmanagementsystem.mapper;

import com.hcms.hostelcomplaintmanagementsystem.dto.StaffRequestDto;
import com.hcms.hostelcomplaintmanagementsystem.dto.StaffResponseDto;
import com.hcms.hostelcomplaintmanagementsystem.dto.StudentRequestDto;
import com.hcms.hostelcomplaintmanagementsystem.dto.StudentResponseDto;
import com.hcms.hostelcomplaintmanagementsystem.model.Staff;
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

    public static Student toStudent(StudentRequestDto studentRequestDto)
    {
        Student student= new Student();

        student.setName(studentRequestDto.getName());
        student.setEmail(studentRequestDto.getEmail());
        student.setPhone(studentRequestDto.getPhone());
        return student;
    }

    public static StaffResponseDto toStaffResponseDto(Staff staf)
    {
        StaffResponseDto staff = new StaffResponseDto();

        staff.setName(staf.getName());
        staff.setEmail(staf.getEmail());
        staff.setRole(staf.getRole());
        staff.setPhone(staf.getPhone());

        return staff;


    }

    public static Staff toStaff(StaffRequestDto staffRequestDto)
    {
        Staff staff= new Staff();
        staff.setName(staffRequestDto.getName());
        staff.setEmail(staffRequestDto.getEmail());
        staff.setRole(staffRequestDto.getRole());
        staff.setPhone(staffRequestDto.getPhone());

        return staff;
    }

}
