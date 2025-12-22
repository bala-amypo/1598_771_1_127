package com.example.demo.service.impl;

import com.example.demo.entity.Complaint;
import com.example.demo.entity.ComplaintStatus;
import com.example.demo.exception.ComplaintStatusNotFoundException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ComplaintRepository;
import com.example.demo.repository.ComplaintStatusRepository;
import com.example.demo.service.ComplaintStatusService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ComplaintStatusServiceImpl implements ComplaintStatusService {

    private final ComplaintStatusRepository statusRepository;
    private final ComplaintRepository complaintRepository;

    // Constructor injection (order matters)
    public ComplaintStatusServiceImpl(ComplaintStatusRepository statusRepository,
                                      ComplaintRepository complaintRepository) {
        this.statusRepository = statusRepository;
        this.complaintRepository = complaintRepository;
    }

    @Override
    public void updateStatus(Long complaintId, String status) {

        Complaint complaint = complaintRepository.findById(complaintId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Complaint not found"));

        // update current complaint status
        complaint.setStatus(
                Complaint.Status.valueOf(status)
        );
        complaintRepository.save(complaint);

        // save status history
        ComplaintStatus complaintStatus = new ComplaintStatus();
        complaintStatus.setComplaint(complaint);
        complaintStatus.setStatus(status);

        statusRepository.save(complaintStatus);
    }

    @Override
    public List<ComplaintStatus> getStatusHistory(Long complaintId) {

        Complaint complaint = complaintRepository.findById(complaintId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Complaint not found"));

        List<ComplaintStatus> history =
                statusRepository.findByComplaint(complaint);

        if (history.isEmpty()) {
            throw new ComplaintStatusNotFoundException(
                    "No status history found");
        }

        return history;
    }
}
