package com.hcms.hostelcomplaintmanagementsystem.service;

import com.hcms.hostelcomplaintmanagementsystem.dto.CategoryRequestDto;
import com.hcms.hostelcomplaintmanagementsystem.dto.CategoryResponseDto;
import com.hcms.hostelcomplaintmanagementsystem.mapper.Mapper;
import com.hcms.hostelcomplaintmanagementsystem.model.Category;
import com.hcms.hostelcomplaintmanagementsystem.repository.CategoryRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepo categoryRepo;

    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public CategoryResponseDto addCategory(CategoryRequestDto categoryRequestDto) {

        return Mapper.toCategoryResponseDto(categoryRepo.save(Mapper.toCategory(categoryRequestDto)));

    }

    public List<CategoryResponseDto> getAllCategory() {

        List<Category> categories= categoryRepo.findAll();

        return categories.stream()
                .map(Mapper::toCategoryResponseDto)
                .toList();

    }
}
