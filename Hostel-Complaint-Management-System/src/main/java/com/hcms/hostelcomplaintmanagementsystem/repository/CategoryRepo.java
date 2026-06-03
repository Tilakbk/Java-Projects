package com.hcms.hostelcomplaintmanagementsystem.repository;

import com.hcms.hostelcomplaintmanagementsystem.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepo extends JpaRepository<Category, UUID> {
}
