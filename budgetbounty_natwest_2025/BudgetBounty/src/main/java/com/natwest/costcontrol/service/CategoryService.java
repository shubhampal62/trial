package com.natwest.costcontrol.service;

import com.natwest.costcontrol.dto.CategoryRequestDTO;
import com.natwest.costcontrol.dto.CategoryResponseDTO;

import java.util.List;

public interface CategoryService {
    CategoryResponseDTO createCategory(CategoryRequestDTO requestDTO);
    CategoryResponseDTO getCategoryById(Long id);
    List<CategoryResponseDTO> getAllCategories();
    CategoryResponseDTO updateCategory(Long id, CategoryRequestDTO requestDTO);
    void deleteCategory(Long id);
}
