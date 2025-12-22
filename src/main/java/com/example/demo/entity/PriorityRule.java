package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class PriorityRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String category;

    private Integer baseScore;

    private String description;

    // getters & setters
    public Long getId() { return id; }
    public String getCategory() { return category; }
    public Integer getBaseScore() { return baseScore; }
    public String getDescription() { return description; }

    public void setId(Long id) { this.id = id; }
    public void setCategory(String category) { this.category = category; }
    public void setBaseScore(Integer baseScore) { this.baseScore = baseScore; }
    public void setDescription(String description) { this.description = description; }
}
