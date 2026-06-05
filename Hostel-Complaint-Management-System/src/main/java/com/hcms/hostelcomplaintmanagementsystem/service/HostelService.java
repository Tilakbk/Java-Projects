package com.hcms.hostelcomplaintmanagementsystem.service;

import com.hcms.hostelcomplaintmanagementsystem.dto.HostelResponseDTO;
import com.hcms.hostelcomplaintmanagementsystem.repository.HostelRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostelService {

    private final HostelRepo hostelRepo;

    public HostelService(HostelRepo hostelRepo) {
        this.hostelRepo = hostelRepo;
    }


    public List<HostelResponseDTO> getAllHostel() {

    }
}
