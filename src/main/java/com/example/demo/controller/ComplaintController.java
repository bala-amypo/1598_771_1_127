package com.example.demo.controller;

import com.example.demo.entity.Complaint;
import com.example.demo.service.ComplaintService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    private final ComplaintService service;

    public ComplaintController(ComplaintService service) {
        this.service = service;
    }

    @PostMapping("/submit")
    public Complaint submit(
            @RequestParam String title,
            @RequestParam String description,
            @RequestParam String category,
            @RequestParam Long userId) {
        return service.submitComplaint(title, description, category, userId);
    }

    @GetMapping("/user/{userId}")
    public List<Complaint> userComplaints(@PathVariable Long userId) {
        return service.getUserComplaints(userId);
    }

    @GetMapping("/prioritized")
    public List<Complaint> prioritized() {
        return service.getPrioritizedComplaints();
    }

    @PutMapping("/status/{id}")
    public void updateStatus(@PathVariable Long id, @RequestParam String status) {
        service.updateComplaintStatus(id, status);
    }
}
