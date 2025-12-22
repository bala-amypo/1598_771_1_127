package com.example.demo.controller;

import com.example.demo.entity.ComplaintStatus;
import com.example.demo.service.ComplaintStatusService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/status")
public class StatusController {

    private final ComplaintStatusService complaintStatusService;

    public StatusController(ComplaintStatusService complaintStatusService) {
        this.complaintStatusService = complaintStatusService;
    }

    @PutMapping("/{complaintId}")
    public String updateStatus(@PathVariable Long complaintId,
                               @RequestParam String status) {
        complaintStatusService.updateStatus(complaintId, status);
        return "Status updated successfully";
    }

    @GetMapping("/history/{complaintId}")
    public List<ComplaintStatus> getHistory(
            @PathVariable Long complaintId) {
        return complaintStatusService.getStatusHistory(complaintId);
    }
}
