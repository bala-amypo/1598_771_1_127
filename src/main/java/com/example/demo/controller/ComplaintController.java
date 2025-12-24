package com.example.demo.controller;

import com.example.demo.dto.ComplaintRequest;
import com.example.demo.entity.Complaint;
import com.example.demo.service.ComplaintService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    private final ComplaintService complaintService;

    public ComplaintController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

    @PostMapping("/submit")
    public ResponseEntity<Complaint> submitComplaint(
            @RequestBody ComplaintRequest request) {
        return ResponseEntity.ok(complaintService.submitComplaint(request));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Complaint>> getUserComplaints(
            @PathVariable Long userId) {
        return ResponseEntity.ok(
                complaintService.getUserComplaints(userId));
    }

    @GetMapping("/prioritized")
    public ResponseEntity<List<Complaint>> getPrioritizedComplaints() {
        return ResponseEntity.ok(
                complaintService.getPrioritizedComplaints());
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<Complaint> updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return ResponseEntity.ok(
                complaintService.updateComplaintStatus(id, status));
    }
}
