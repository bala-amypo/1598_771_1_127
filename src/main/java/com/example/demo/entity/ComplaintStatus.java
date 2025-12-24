package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ComplaintStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "complaint_id")
    private Complaint complaint;

    private String status;

    private LocalDateTime updatedOn;

    @PrePersist
    public void onUpdate() {
        this.updatedOn = LocalDateTime.now();
    }

    // Constructors
    public ComplaintStatus() {}

    public ComplaintStatus(Complaint complaint, String status) {
        this.complaint = complaint;
        this.status = status;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public Complaint getComplaint() {
        return complaint;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setComplaint(Complaint complaint) {
        this.complaint = complaint;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
