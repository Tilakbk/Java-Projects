package com.hcms.hostelcomplaintmanagementsystem.repository;

import com.hcms.hostelcomplaintmanagementsystem.model.ResolutionLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ResolutionLogRepo extends JpaRepository<ResolutionLog, UUID> {
}
