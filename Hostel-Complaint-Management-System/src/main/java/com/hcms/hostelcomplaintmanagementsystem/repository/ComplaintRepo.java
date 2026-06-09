package com.hcms.hostelcomplaintmanagementsystem.repository;

import com.hcms.hostelcomplaintmanagementsystem.model.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ComplaintRepo extends JpaRepository<Complaint, UUID> {


    List<Complaint> findAllByStatus(String status);
}
