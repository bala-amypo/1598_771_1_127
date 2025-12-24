package com.example.demo.dto;

public class ComplaintResponse {

    private Long complaintId;
    private String message;

    public ComplaintResponse() {}

    public ComplaintResponse(Long complaintId, String message) {
        this.complaintId = complaintId;
        this.message = message;
    }

    public Long getComplaintId() {
        return complaintId;
    }

    public String getMessage() {
        return message;
    }

    public void setComplaintId(Long complaintId) {
        this.complaintId = complaintId;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
