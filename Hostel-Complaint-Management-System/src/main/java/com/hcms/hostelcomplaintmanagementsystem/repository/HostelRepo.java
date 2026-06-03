package com.hcms.hostelcomplaintmanagementsystem.repository;

import com.hcms.hostelcomplaintmanagementsystem.model.Hostel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HostelRepo extends JpaRepository<Hostel, UUID> {
}
