package com.example.demo.entity;

import java.time.LocalDateTime;

public class ComplaintStatus {
    private Long id;
    private LocalDateTime SubmittedOn;
    private String status;
    private  ManyToOne User complaint;
}