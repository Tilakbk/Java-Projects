package com.hcms.hostelcomplaintmanagementsystem.controller;

import com.hcms.hostelcomplaintmanagementsystem.dto.CategoryRequestDto;
import com.hcms.hostelcomplaintmanagementsystem.dto.CategoryResponseDto;
import com.hcms.hostelcomplaintmanagementsystem.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;



    @PostMapping("/category")
    @PreAuthorize("hasRole('WARDEN')")
    public ResponseEntity<CategoryResponseDto> addCategory(@Valid @RequestBody CategoryRequestDto categoryRequestDto)
    {
        return ResponseEntity.ok(categoryService.addCategory(categoryRequestDto));
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/category")
    public ResponseEntity<List<CategoryResponseDto>> getAllCategory()
    {
        return ResponseEntity.ok(categoryService.getAllCategory());
    }

    @GetMapping("/category/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<CategoryResponseDto> getCategoryById(@PathVariable UUID id)
    {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    @PutMapping("/category/{id}")
    @PreAuthorize("hasRole('WARDEN')")
    public ResponseEntity<CategoryResponseDto> updateCategory(@PathVariable UUID id,@Valid @RequestBody CategoryRequestDto categoryRequestDto)
    {
        return ResponseEntity.ok(categoryService.updateCategory(id,categoryRequestDto));
    }

    @DeleteMapping("/category/{id}")
    @PreAuthorize("hasRole('WARDEN')")
    public ResponseEntity<String> deleteCategory(@PathVariable UUID id)
    {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Deleted successfully");
    }

}
