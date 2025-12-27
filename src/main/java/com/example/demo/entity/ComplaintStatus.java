package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "complaint_status")
public class ComplaintStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private LocalDateTime updatedOn;

    @ManyToOne
    @JoinColumn(name = "complaint_id")
    private Complaint complaint;

    @PrePersist
    public void onUpdate() {
        this.updatedOn = LocalDateTime.now();
    }

    public ComplaintStatus() {}

    public Long getId() {
         return id; 
         }
    public void setId(Long id) { 
        this.id = id;
         }

    public String getStatus() {
         return status; 
         }
    public void setStatus(String status) {
     this.status = status;
      }

    public LocalDateTime getUpdatedOn() {
         return updatedOn; 
         }

    public Complaint getComplaint() {
         return complaint;
          }
    public void setComplaint(Complaint complaint) {
         this.complaint = complaint;
          }
}
