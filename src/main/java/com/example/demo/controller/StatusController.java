package com.example.demo.controller;

import com.example.demo.entity.Complaint;
import com.example.demo.entity.ComplaintStatus;
import com.example.demo.repository.ComplaintRepository;
import com.example.demo.service.ComplaintStatusService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/status")
public class StatusController {

    private final ComplaintStatusService complaintStatusService;
    private final ComplaintRepository complaintRepository;

    public StatusController(ComplaintStatusService complaintStatusService,
                            ComplaintRepository complaintRepository) {
        this.complaintStatusService = complaintStatusService;
        this.complaintRepository = complaintRepository;
    }

    @PutMapping("/update/{complaintId}")
    public ComplaintStatus updateStatus(@PathVariable Long complaintId,
                                        @RequestParam Complaint.Status status) {

        Complaint complaint = complaintRepository.findById(complaintId)
                .orElseThrow(() -> new RuntimeException("Complaint not found"));

        return complaintStatusService.updateStatus(complaint, status);
    }

    @GetMapping("/history/{complaintId}")
    public List<ComplaintStatus> getStatusHistory(@PathVariable Long complaintId) {

        Complaint complaint = complaintRepository.findById(complaintId)
                .orElseThrow(() -> new RuntimeException("Complaint not found"));

        return complaintStatusService.getStatusHistory(complaint);
    }
}
