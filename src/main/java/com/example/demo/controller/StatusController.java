package com.example.demo.controller;

import com.example.demo.entity.ComplaintStatus;
import com.example.demo.service.ComplaintStatusService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/status")
public class StatusController {

    private final ComplaintStatusService complaintStatusService;

    public StatusController(ComplaintStatusService complaintStatusService) {
        this.complaintStatusService = complaintStatusService;
    }

    @PostMapping
    public ComplaintStatus addStatus(@RequestBody ComplaintStatus status) {
        return complaintStatusService.addStatus(status);
    }

    @GetMapping("/complaint/{id}")
    public List<ComplaintStatus> getStatusByComplaint(@PathVariable Long id) {
        return complaintStatusService.getStatusByComplaintId(id);
    }
}
