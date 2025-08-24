package com.natwest.costcontrol.dto;

public class CategoryRequestDTO {
    private String categoryName;
    private String description;

    // Getters and Setters
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
