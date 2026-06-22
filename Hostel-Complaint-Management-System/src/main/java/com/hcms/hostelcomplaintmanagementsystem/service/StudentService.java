package com.hcms.hostelcomplaintmanagementsystem.service;

import com.hcms.hostelcomplaintmanagementsystem.dto.StudentPatchDto;
import com.hcms.hostelcomplaintmanagementsystem.dto.StudentRequestDto;
import com.hcms.hostelcomplaintmanagementsystem.dto.StudentResponseDto;
import com.hcms.hostelcomplaintmanagementsystem.exceptionhandling.*;
import com.hcms.hostelcomplaintmanagementsystem.mapper.Mapper;
import com.hcms.hostelcomplaintmanagementsystem.model.Student;
import com.hcms.hostelcomplaintmanagementsystem.repository.HostelRepo;
import com.hcms.hostelcomplaintmanagementsystem.repository.RoomRepo;
import com.hcms.hostelcomplaintmanagementsystem.repository.StudentRepo;
import com.hcms.hostelcomplaintmanagementsystem.user.Role;
import com.hcms.hostelcomplaintmanagementsystem.user.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepo studentRepo;
    private final RoomRepo roomRepo;
    private final HostelRepo hostelRepo;
    private final UserAccountService userAccountService;


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

        userAccountService.createUser(student.getName(), student.getEmail(), studentRequestDto.getPassword(), Role.STUDENT,student.getHostel(),student,null);

        return Mapper.toStudentResponseDto(studentRepo.save(student));

    }

    public StudentResponseDto getStudentById(UUID id)
    {
        Student student= studentRepo.findById(id).orElseThrow(()->new StudentNotValidException(id+"Student With this Id does not exists"));
        return Mapper.toStudentResponseDto(student);

    }

    public StudentResponseDto updateStudentById(UUID id, StudentRequestDto studentRequestDto) {

        Student student = studentRepo.findById(id).orElseThrow(()->new StudentNotValidException(id+" Student With this Id does not exists"));
        student.setName(studentRequestDto.getName());
        student.setPhone(studentRequestDto.getPhone());
        student.setEmail(studentRequestDto.getEmail());
        student.setRoom(roomRepo.findById(studentRequestDto.getRoom_id()).orElseThrow(()->new RoomNotValidException(studentRequestDto.getRoom_id()+" Room with this id does not exists")));
        student.setHostel(hostelRepo.findById(studentRequestDto.getHostel_id()).orElseThrow(()->new HostelNotValidException(studentRequestDto.getHostel_id()+" Hostel with this Id does not exist")));

        return Mapper.toStudentResponseDto(studentRepo.save(student));
    }

    public StudentResponseDto partiallyUpdateStudentById(UUID id, StudentPatchDto studentPatchDto) {
        Student student = studentRepo.findById(id).orElseThrow(()->new StudentNotValidException(id+" Student With this Id doesn't exists"));

        if (studentPatchDto.getName()!=null)
        {
            student.setName(studentPatchDto.getName());
        }

        if (studentPatchDto.getEmail()!=null)
        {
            student.setEmail(studentPatchDto.getEmail());
        }

        if (studentPatchDto.getPhone()!=null)
        {
            student.setPhone(studentPatchDto.getPhone());
        }

        if (studentPatchDto.getRoom_id()!=null)
        {
            student.setRoom(roomRepo.findById(studentPatchDto.getRoom_id()).orElseThrow(()->new RoomNotValidException(studentPatchDto.getRoom_id()+" Room with this id does not exists")));
        }



        if (studentPatchDto.getHostel_id()!=null)
        {
            student.setHostel(hostelRepo.findById(studentPatchDto.getHostel_id()).orElseThrow(()->new HostelNotValidException(studentPatchDto.getHostel_id()+" Hostel with this id does not exists")));
        }

        return Mapper.toStudentResponseDto(studentRepo.save(student));
    }

    public void deleteStudentById(UUID id) {

        Student student = studentRepo.findById(id).orElseThrow(()->new StudentNotValidException(id+" Student with this id does not exist "));

        studentRepo.delete(student);

    }
}
