package com.natwest.costcontrol.controller;

import com.natwest.costcontrol.dto.CategoryRequestDTO;
import com.natwest.costcontrol.dto.CategoryResponseDTO;
import com.natwest.costcontrol.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> createCategory(@RequestBody CategoryRequestDTO requestDTO) {
        return ResponseEntity.ok(categoryService.createCategory(requestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> updateCategory(@PathVariable Long id,
                                                              @RequestBody CategoryRequestDTO requestDTO) {
        return ResponseEntity.ok(categoryService.updateCategory(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Category deleted successfully!");
    }
}
