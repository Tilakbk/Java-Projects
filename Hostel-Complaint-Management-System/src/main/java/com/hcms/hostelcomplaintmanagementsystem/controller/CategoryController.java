package com.hcms.hostelcomplaintmanagementsystem.controller;

import com.hcms.hostelcomplaintmanagementsystem.dto.CategoryRequestDto;
import com.hcms.hostelcomplaintmanagementsystem.dto.CategoryResponseDto;
import com.hcms.hostelcomplaintmanagementsystem.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/category")
    public ResponseEntity<CategoryResponseDto> addCategory(@Valid @RequestBody CategoryRequestDto categoryRequestDto)
    {
        return ResponseEntity.ok(categoryService.addCategory(categoryRequestDto));
    }

    @GetMapping("/category")
    public ResponseEntity<List<CategoryResponseDto>> getAllCategory()
    {
        return ResponseEntity.ok(categoryService.getAllCategory());
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<CategoryResponseDto> getCategoryById(@PathVariable UUID id)
    {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }


}
