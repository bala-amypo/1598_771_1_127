package com.example.demo.controller;

import com.example.demo.entity.Complaint;
import com.example.demo.entity.User;
import com.example.demo.service.ComplaintService;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    private final ComplaintService complaintService;
    private final UserService userService;

    public ComplaintController(ComplaintService complaintService,
                               UserService userService) {
        this.complaintService = complaintService;
        this.userService = userService;
    }

    @PostMapping("/submit/{userId}")
    public Complaint submitComplaint(@PathVariable Long userId,
                                     @RequestBody Complaint complaint) {
        User user = userService.findById(userId);
        return complaintService.submitComplaint(complaint, user);
    }

    @GetMapping("/user/{userId}")
    public List<Complaint> getUserComplaints(@PathVariable Long userId) {
        User user = userService.findById(userId);
        return complaintService.getComplaintsForUser(user);
    }

    @GetMapping("/prioritized")
    public List<Complaint> getPrioritizedComplaints() {
        return complaintService.getPrioritizedComplaints();
    }

    @PutMapping("/status/{complaintId}")
    public Complaint updateStatus(@PathVariable Long complaintId,
                                  @RequestParam Complaint.Status status) {
        return complaintService.updateStatus(complaintId, status);
    }
}
