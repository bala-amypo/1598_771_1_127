package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ComplaintStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Complaint complaint;

    private String status;

    private LocalDateTime updatedOn;

    @PrePersist
    public void onCreate() {
        this.updatedOn = LocalDateTime.now();
    }

    // getters & setters
    public Long getId() { return id; }
    public Complaint getComplaint() { return complaint; }
    public String getStatus() { return status; }
    public LocalDateTime getUpdatedOn() { return updatedOn; }

    public void setComplaint(Complaint complaint) { this.complaint = complaint; }
    public void setStatus(String status) { this.status = status; }
}
