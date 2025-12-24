package com.example.demo.controller;

import com.example.demo.entity.ComplaintStatus;
import com.example.demo.service.ComplaintStatusService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/status")
public class ComplaintStatusController {

    private final ComplaintStatusService complaintStatusService;

    public ComplaintStatusController(ComplaintStatusService complaintStatusService) {
        this.complaintStatusService = complaintStatusService;
    }

    @GetMapping("/history/{complaintId}")
    public List<ComplaintStatus> getStatusHistory(
            @PathVariable Long complaintId) {
        return complaintStatusService.getStatusHistory(complaintId);
    }
}
