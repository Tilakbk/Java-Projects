package com.hcms.hostelcomplaintmanagementsystem.service;

import com.hcms.hostelcomplaintmanagementsystem.dto.RoomRequestDto;
import com.hcms.hostelcomplaintmanagementsystem.dto.RoomResponseDto;
import com.hcms.hostelcomplaintmanagementsystem.exceptionhandling.HostelNotValidException;
import com.hcms.hostelcomplaintmanagementsystem.exceptionhandling.RoomAlreadyExistsException;
import com.hcms.hostelcomplaintmanagementsystem.exceptionhandling.RoomNotValidException;
import com.hcms.hostelcomplaintmanagementsystem.mapper.Mapper;
import com.hcms.hostelcomplaintmanagementsystem.model.Room;
import com.hcms.hostelcomplaintmanagementsystem.repository.HostelRepo;
import com.hcms.hostelcomplaintmanagementsystem.repository.RoomRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoomService {

    private final RoomRepo roomRepo;
    private final HostelRepo hostelRepo;

    public RoomService(RoomRepo roomRepo,HostelRepo hostelRepo) {
        this.roomRepo = roomRepo;
        this.hostelRepo=hostelRepo;
    }

    public RoomResponseDto addRoom(RoomRequestDto roomRequestDto) {

        if (roomRepo.existsByRoomNumberAndHostel_HostelId(roomRequestDto.getRoomNumber(),roomRequestDto.getHostelId()))
        {
            throw new RoomAlreadyExistsException("This room already exists");
        }
        Room room= Mapper.toRoom(roomRequestDto);
        room.setHostel(hostelRepo.findById(roomRequestDto.getHostelId()).orElseThrow(()->new HostelNotValidException(roomRequestDto.getHostelId()+" This id does not belongs to any hostel")));


        return Mapper.toRomResponseDto(roomRepo.save(room));

    }

    public List<RoomResponseDto> getAllRoom() {

        List<Room> rooms= roomRepo.findAll();

        return rooms.stream()
                .map(Mapper::toRomResponseDto)
                .toList();


    }

    public RoomResponseDto getRoomById(UUID id) {

        Room room = roomRepo.findById(id).orElseThrow(()->new RoomNotValidException(id+" Room with this id does not exists"));

        return Mapper.toRomResponseDto(room);

    }
}
