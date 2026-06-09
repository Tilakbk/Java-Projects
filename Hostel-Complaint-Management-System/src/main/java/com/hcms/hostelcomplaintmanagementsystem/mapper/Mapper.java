package com.hcms.hostelcomplaintmanagementsystem.mapper;

import com.hcms.hostelcomplaintmanagementsystem.dto.*;
import com.hcms.hostelcomplaintmanagementsystem.model.*;


public class Mapper {


    public static StudentResponseDto toStudentResponseDto(Student student)
    {
        StudentResponseDto studentResponseDto= new StudentResponseDto();

        studentResponseDto.setName(student.getName());
        studentResponseDto.setEmail(student.getEmail());
        studentResponseDto.setPhone(student.getPhone());
        studentResponseDto.setRoom_number(student.getRoom().getRoomNumber());
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

    public static HostelResponseDTO toHostelResponseDto(Hostel hostel)
    {
        HostelResponseDTO hostelResponseDTO = new HostelResponseDTO();
        hostelResponseDTO.setId(hostel.getHostelId());
        hostelResponseDTO.setName(hostel.getName());
        hostelResponseDTO.setAddress(hostel.getAddress());
        hostelResponseDTO.setWardenName(hostel.getStaff().getName());

        return hostelResponseDTO;
    }

    public static Hostel toHostel(HostelRequestDto hostelRequestDto)
    {
        Hostel hostel= new Hostel();
        hostel.setName(hostelRequestDto.getName());
        hostel.setAddress(hostelRequestDto.getAddress());
         return  hostel;
    }

    public static RoomResponseDto toRomResponseDto(Room room)
    {
        RoomResponseDto roomResponseDto= new RoomResponseDto();
        roomResponseDto.setRoomId(room.getRoomId());
        roomResponseDto.setRoomNumber(room.getRoomNumber());
        roomResponseDto.setRoomCapacity(room.getCapacity());

        return roomResponseDto;
    }

    public static Room toRoom(RoomRequestDto roomRequestDto)
    {
        Room room= new Room();
        room.setRoomNumber(roomRequestDto.getRoomNumber());
        room.setCapacity(roomRequestDto.getRoomCapacity());

        return room;
    }

    public static ResolutionLogResponseDto toResolutionResponseDto(ResolutionLog resolutionLog)
    {
        ResolutionLogResponseDto resolutionLogResponseDto= new ResolutionLogResponseDto();

        resolutionLogResponseDto.setResolutionLogId(resolutionLog.getLogId());
        resolutionLogResponseDto.setComplaint(resolutionLog.getComplaint().getDescription());
        resolutionLogResponseDto.setStaffName(resolutionLog.getStaff().getName());
        resolutionLogResponseDto.setActionTaken(resolutionLog.getActionTaken());

        return resolutionLogResponseDto;
    }

    public static ResolutionLog toResolutionLog(ResolutionLogRequestDto resolutionLogRequestDto)
    {
        ResolutionLog resolutionLog= new ResolutionLog();

        resolutionLog.setActionTaken(resolutionLog.getActionTaken());

        return resolutionLog;
    }

    public static CategoryResponseDto toCategoryResponseDto(Category category)
    {
        CategoryResponseDto categoryResponseDto= new CategoryResponseDto();

        categoryResponseDto.setCategoryId(category.getCategoryId());
        categoryResponseDto.setCategoryName(category.getCategoryName());

        return categoryResponseDto;
    }
}
