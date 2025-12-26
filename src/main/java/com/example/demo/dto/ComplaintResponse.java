package com.example.demo.dto;

import com.example.demo.entity.Complaint;

public class ComplaintResponse {

    private Long id;
    private String status;
    private Integer priorityScore;

    public ComplaintResponse(Complaint complaint) {
        this.id = complaint.getId();
        this.status = complaint.getStatus().name();
        this.priorityScore = complaint.getPriorityScore();
    }

    // ===== Getters =====

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public Integer getPriorityScore() {
        return priorityScore;
    }
}
