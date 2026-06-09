package com.hcms.hostelcomplaintmanagementsystem.service;

import com.hcms.hostelcomplaintmanagementsystem.dto.CategoryRequestDto;
import com.hcms.hostelcomplaintmanagementsystem.dto.CategoryResponseDto;
import com.hcms.hostelcomplaintmanagementsystem.mapper.Mapper;
import com.hcms.hostelcomplaintmanagementsystem.repository.CategoryRepo;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryRepo categoryRepo;

    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public CategoryResponseDto addCategory(CategoryRequestDto categoryRequestDto) {

        return Mapper.toCategoryResponseDto(categoryRepo.save(Mapper.toCategory(categoryRequestDto)));

    }
}
