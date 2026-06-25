package com.aishop.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductForm {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String category;

    @NotNull
    private Long price;

    @NotNull
    private Integer stock;

    private Integer aiRecommendScore;
    private String description;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public Long getPrice() { return price; }
    public void setPrice(Long price) { this.price = price; }
    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }
    public Integer getAiRecommendScore() { return aiRecommendScore; }
    public void setAiRecommendScore(Integer aiRecommendScore) { this.aiRecommendScore = aiRecommendScore; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
