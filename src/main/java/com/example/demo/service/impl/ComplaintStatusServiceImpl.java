package com.example.demo.service.impl;

import com.example.demo.entity.Complaint;
import com.example.demo.entity.ComplaintStatus;
import com.example.demo.repository.ComplaintStatusRepository;
import com.example.demo.service.ComplaintStatusService;

import java.util.List;

public class ComplaintStatusServiceImpl implements ComplaintStatusService {

    private final ComplaintStatusRepository complaintStatusRepository;

    public ComplaintStatusServiceImpl(ComplaintStatusRepository complaintStatusRepository) {
        this.complaintStatusRepository = complaintStatusRepository;
    }

    @Override
    public ComplaintStatus updateStatus(Complaint complaint, Complaint.Status status) {

        // Update current complaint status
        complaint.setStatus(status);

        // Create status history record
        ComplaintStatus complaintStatus = new ComplaintStatus();
        complaintStatus.setComplaint(complaint);
        complaintStatus.setStatus(status);

        return complaintStatusRepository.save(complaintStatus);
    }

    @Override
    public List<ComplaintStatus> getStatusHistory(Complaint complaint) {
        return complaintStatusRepository.findByComplaint(complaint);
    }
}
