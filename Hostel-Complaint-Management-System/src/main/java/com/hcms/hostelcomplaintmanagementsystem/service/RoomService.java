package com.hcms.hostelcomplaintmanagementsystem.service;

import com.hcms.hostelcomplaintmanagementsystem.dto.RoomRequestDto;
import com.hcms.hostelcomplaintmanagementsystem.dto.RoomResponseDto;
import com.hcms.hostelcomplaintmanagementsystem.exceptionhandling.HostelNotValidException;
import com.hcms.hostelcomplaintmanagementsystem.mapper.Mapper;
import com.hcms.hostelcomplaintmanagementsystem.model.Room;
import com.hcms.hostelcomplaintmanagementsystem.repository.HostelRepo;
import com.hcms.hostelcomplaintmanagementsystem.repository.RoomRepo;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    private final RoomRepo roomRepo;
    private final HostelRepo hostelRepo;

    public RoomService(RoomRepo roomRepo,HostelRepo hostelRepo) {
        this.roomRepo = roomRepo;
        this.hostelRepo=hostelRepo;
    }

    public RoomResponseDto addRoom(RoomRequestDto roomRequestDto) {

        if (roomRepo.existsByRoomNumber(roomRequestDto.getRoomNumber()))
        {
            throw new RoomAlreadyExistsException("This room already exists");
        }
        Room room= Mapper.toRoom(roomRequestDto);
        room.setHostel(hostelRepo.findById(roomRequestDto.getHostelId()).orElseThrow(()->new HostelNotValidException(roomRequestDto.getHostelId()+" This id does not belongs to any hostel")));


        return Mapper.toRomResponseDto(roomRepo.save(room));

    }
}
