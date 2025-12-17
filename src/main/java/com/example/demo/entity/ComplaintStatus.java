package com.example.demo.entity;

import java.time.LocalDateTime;

public class User {
    private Long id;
    private String status;
    private LocalDateTime SubmittedOn;
    private  ManyToOne User complaint;
}