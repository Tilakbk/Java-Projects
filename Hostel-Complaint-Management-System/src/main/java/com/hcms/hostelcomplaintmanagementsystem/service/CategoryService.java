package com.hcms.hostelcomplaintmanagementsystem.service;

import com.hcms.hostelcomplaintmanagementsystem.dto.CategoryRequestDto;
import com.hcms.hostelcomplaintmanagementsystem.dto.CategoryResponseDto;
import com.hcms.hostelcomplaintmanagementsystem.exceptionhandling.CategoryAlreadyExistException;
import com.hcms.hostelcomplaintmanagementsystem.exceptionhandling.CategoryNotValidException;
import com.hcms.hostelcomplaintmanagementsystem.mapper.Mapper;
import com.hcms.hostelcomplaintmanagementsystem.model.Category;
import com.hcms.hostelcomplaintmanagementsystem.repository.CategoryRepo;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {

    private final CategoryRepo categoryRepo;

    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public CategoryResponseDto addCategory(CategoryRequestDto categoryRequestDto) {

        if (categoryRepo.existsByCategoryName(categoryRequestDto.getCategoryName()))
        {
            throw new CategoryAlreadyExistException(categoryRequestDto.getCategoryName()+" This already exist");
        }

        return Mapper.toCategoryResponseDto(categoryRepo.save(Mapper.toCategory(categoryRequestDto)));

    }

    public List<CategoryResponseDto> getAllCategory() {

        List<Category> categories= categoryRepo.findAll();

        return categories.stream()
                .map(Mapper::toCategoryResponseDto)
                .toList();

    }

    public CategoryResponseDto getCategoryById(UUID id) {

        Category category= categoryRepo.findById(id).orElseThrow(()->new CategoryNotValidException(id+" Category with this id does not exist"));

        return Mapper.toCategoryResponseDto(category);

    }

    public CategoryResponseDto updateCategory(UUID id, @Valid CategoryRequestDto categoryRequestDto) {

        Category category= categoryRepo.findById(id).orElseThrow(()->new CategoryNotValidException(id+" Category with this id does not exist"));
        if (categoryRepo.existsByCategoryName(categoryRequestDto.getCategoryName()))
        {
            throw new CategoryAlreadyExistException(categoryRequestDto.getCategoryName()+" This already exist");
        }

        category.setCategoryName(categoryRequestDto.getCategoryName());

        return Mapper.toCategoryResponseDto(categoryRepo.save(category));


    }
}
