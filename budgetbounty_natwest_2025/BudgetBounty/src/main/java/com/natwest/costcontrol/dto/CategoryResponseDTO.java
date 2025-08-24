package com.natwest.costcontrol.dto;

public class CategoryResponseDTO {
    private Long categoryId;
    private String categoryName;
    private String description;

    // Getters and Setters
    public Long getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
