package com.aishop.backend.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = false, length = 50)
    private String category;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false)
    private Integer stock;

    @Column(name = "ai_recommend_score")
    private Integer aiRecommendScore;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    protected Product() {}

    public Product(String name, String category, Long price, Integer stock,
                   Integer aiRecommendScore, String description) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
        this.aiRecommendScore = aiRecommendScore;
        this.description = description;
    }

    public void update(String name, String category, Long price, Integer stock,
                       Integer aiRecommendScore, String description) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
        this.aiRecommendScore = aiRecommendScore;
        this.description = description;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public Long getPrice() { return price; }
    public Integer getStock() { return stock; }
    public Integer getAiRecommendScore() { return aiRecommendScore; }
    public String getDescription() { return description; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
