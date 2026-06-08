package com.hcms.hostelcomplaintmanagementsystem.service;

import com.hcms.hostelcomplaintmanagementsystem.dto.HostelRequestDto;
import com.hcms.hostelcomplaintmanagementsystem.dto.HostelResponseDTO;
import com.hcms.hostelcomplaintmanagementsystem.dto.RoomResponseDto;
import com.hcms.hostelcomplaintmanagementsystem.exceptionhandling.HostelNotValidException;
import com.hcms.hostelcomplaintmanagementsystem.exceptionhandling.StaffNotValidException;
import com.hcms.hostelcomplaintmanagementsystem.mapper.Mapper;
import com.hcms.hostelcomplaintmanagementsystem.model.Hostel;
import com.hcms.hostelcomplaintmanagementsystem.model.Room;
import com.hcms.hostelcomplaintmanagementsystem.repository.HostelRepo;
import com.hcms.hostelcomplaintmanagementsystem.repository.RoomRepo;
import com.hcms.hostelcomplaintmanagementsystem.repository.StaffRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HostelService {

    private final HostelRepo hostelRepo;
    private final StaffRepo staffRepo;
    private final RoomRepo roomRepo;

    public HostelService(HostelRepo hostelRepo, StaffRepo staffRepo, RoomRepo roomRepo) {
        this.staffRepo=staffRepo;
        this.hostelRepo = hostelRepo;
        this.roomRepo= roomRepo;
    }


    public List<HostelResponseDTO> getAllHostel() {

        List<Hostel> hostels = hostelRepo.findAll();

        return hostels.stream()
                .map(Mapper::toHostelResponseDto)
                .toList();

    }

    public HostelResponseDTO addHostel(HostelRequestDto hostelRequestDto) {

        Hostel hostel = Mapper.toHostel(hostelRequestDto);
        hostel.setStaff(staffRepo.findById(hostelRequestDto.getWardenId()).orElseThrow(()->new StaffNotValidException(hostelRequestDto.getWardenId()+" Warden with this id does not exist")));

        return Mapper.toHostelResponseDto(hostelRepo.save(hostel));

    }

    public HostelResponseDTO getHostelById(UUID id) {

        Hostel hostel= hostelRepo.findById(id).orElseThrow(()-> new HostelNotValidException(id+" This hostel does not exist"));

        return Mapper.toHostelResponseDto(hostel);

    }

    public List<RoomResponseDto> getHostelRoomById(UUID id) {

         List<Room> rooms= roomRepo.findByHostel_HostelId(id);

        return rooms.stream()
                 .map(Mapper::toRomResponseDto)
                 .toList();




    }

    public HostelResponseDTO updateHostel(HostelRequestDto hostelRequestDto, UUID id) {

        Hostel hostel = hostelRepo.findById(id).orElseThrow(()->new HostelNotValidException(id+" This hostel id does not exist"));

        hostel.setName(hostelRequestDto.getName());
        hostel.setAddress(hostelRequestDto.getAddress());

        return Mapper.toHostelResponseDto(hostelRepo.save(hostel));

    }

    public void deleteHostel(UUID id) {

        hostelRepo.delete(hostelRepo.findById(id).orElseThrow(()-> new HostelNotValidException(id+" This id does not belongs to any hostel")));


    }
}
