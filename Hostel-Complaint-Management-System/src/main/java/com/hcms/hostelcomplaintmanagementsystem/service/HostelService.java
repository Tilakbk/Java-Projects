package com.hcms.hostelcomplaintmanagementsystem.service;

import com.hcms.hostelcomplaintmanagementsystem.dto.HostelRequestDto;
import com.hcms.hostelcomplaintmanagementsystem.dto.HostelResponseDTO;
import com.hcms.hostelcomplaintmanagementsystem.exceptionhandling.StaffNotValidException;
import com.hcms.hostelcomplaintmanagementsystem.mapper.Mapper;
import com.hcms.hostelcomplaintmanagementsystem.model.Hostel;
import com.hcms.hostelcomplaintmanagementsystem.repository.HostelRepo;
import com.hcms.hostelcomplaintmanagementsystem.repository.StaffRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostelService {

    private final HostelRepo hostelRepo;
    private final StaffRepo staffRepo;

    public HostelService(HostelRepo hostelRepo, StaffRepo staffRepo) {
        this.staffRepo=staffRepo;
        this.hostelRepo = hostelRepo;
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
}
