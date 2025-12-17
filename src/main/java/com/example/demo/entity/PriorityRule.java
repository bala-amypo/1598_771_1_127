package com.example.demo.entity;

import java.time.LocalDateTime;

public class User {
    private Long id;
    private String title;
    private String description;
    private String category;
    private Integer priorityScore;
    private LocalDateTime SubmittedOn;
    private  ManyToOne User user;
}