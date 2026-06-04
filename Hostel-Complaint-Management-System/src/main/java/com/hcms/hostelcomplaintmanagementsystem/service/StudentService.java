package com.hcms.hostelcomplaintmanagementsystem.service;

import com.hcms.hostelcomplaintmanagementsystem.dto.StudentRequestDto;
import com.hcms.hostelcomplaintmanagementsystem.dto.StudentResponseDto;
import com.hcms.hostelcomplaintmanagementsystem.exceptionhandling.*;
import com.hcms.hostelcomplaintmanagementsystem.mapper.Mapper;
import com.hcms.hostelcomplaintmanagementsystem.model.Student;
import com.hcms.hostelcomplaintmanagementsystem.repository.HostelRepo;
import com.hcms.hostelcomplaintmanagementsystem.repository.RoomRepo;
import com.hcms.hostelcomplaintmanagementsystem.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

        if (studentRepo.existsByEmail(studentRequestDto.getEmail()))
        {
            throw new EmailAlreadyExistsException(studentRequestDto.getEmail() +"This email already exists");
        }

        if (studentRequestDto.getPhone()!=null && studentRepo.existsByPhone(studentRequestDto.getPhone()) )
        {
            throw new PhoneAlreadyExistsException(studentRequestDto.getPhone() +"This phone already exists");
        }

        Student student= Mapper.toStudent(studentRequestDto);
        student.setRoom(roomRepo.findById(studentRequestDto.getRoom_id()).orElseThrow(()->new RoomNotValidException(studentRequestDto.getRoom_id()+" Room with this id does not exists") ));
        student.setHostel(hostelRepo.findById(studentRequestDto.getHostel_id()).orElseThrow(()->new HostelNotValidException(studentRequestDto.getHostel_id()+" Hostel with this Id does not exist")));

        return Mapper.toStudentResponseDto(studentRepo.save(student));

    }

    public StudentResponseDto getStudentById(UUID id)
    {
        Student student= studentRepo.findById(id).orElseThrow(()->new StudentNotValidException(id+"Student With this Id does not exists"));
        return Mapper.toStudentResponseDto(student);

    }
}
