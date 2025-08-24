package com.natwest.costcontrol.service.impl;

import com.natwest.costcontrol.dto.CategoryRequestDTO;
import com.natwest.costcontrol.dto.CategoryResponseDTO;
import com.natwest.costcontrol.model.Category;
import com.natwest.costcontrol.repository.CategoryRepository;
import com.natwest.costcontrol.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryResponseDTO createCategory(CategoryRequestDTO requestDTO) {
        Category category = new Category();
        category.setCategoryName(requestDTO.getCategoryName());
        category.setDescription(requestDTO.getDescription());

        Category saved = categoryRepository.save(category);

        return mapToResponseDTO(saved);
    }

    @Override
    public CategoryResponseDTO getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id " + id));
        return mapToResponseDTO(category);
    }

    @Override
    public List<CategoryResponseDTO> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryResponseDTO updateCategory(Long id, CategoryRequestDTO requestDTO) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id " + id));

        category.setCategoryName(requestDTO.getCategoryName());
        category.setDescription(requestDTO.getDescription());

        Category updated = categoryRepository.save(category);
        return mapToResponseDTO(updated);
    }

    @Override
    public void deleteCategory(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new RuntimeException("Category not found with id " + id);
        }
        categoryRepository.deleteById(id);
    }

    private CategoryResponseDTO mapToResponseDTO(Category category) {
        CategoryResponseDTO dto = new CategoryResponseDTO();
        dto.setCategoryId(category.getCategoryId());
        dto.setCategoryName(category.getCategoryName());
        dto.setDescription(category.getDescription());
        return dto;
    }
}
