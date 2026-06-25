package com.aishop.backend.dto;

import com.aishop.backend.domain.Product;

public class ProductResponse {

    private final Long id;
    private final String name;
    private final String category;
    private final Long price;
    private final Integer stock;
    private final Integer aiRecommendScore;
    private final String description;

    public ProductResponse(Product p) {
        this.id = p.getId();
        this.name = p.getName();
        this.category = p.getCategory();
        this.price = p.getPrice();
        this.stock = p.getStock();
        this.aiRecommendScore = p.getAiRecommendScore();
        this.description = p.getDescription();
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public Long getPrice() { return price; }
    public Integer getStock() { return stock; }
    public Integer getAiRecommendScore() { return aiRecommendScore; }
    public String getDescription() { return description; }
}
