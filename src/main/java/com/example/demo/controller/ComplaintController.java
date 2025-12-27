package com.example.demo.controller;

import com.example.demo.dto.ComplaintRequest;
import com.example.demo.entity.Complaint;
import com.example.demo.entity.User;
import com.example.demo.service.ComplaintService;
import com.example.demo.service.UserService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    private final ComplaintService complaintService;
    private final UserService userService;

    public ComplaintController(
            ComplaintService complaintService,
            UserService userService) {

        this.complaintService = complaintService;
        this.userService = userService;
    }
    @PostMapping("/submit/{userId}")
    public ResponseEntity<Complaint> submitComplaint(
            @PathVariable Long userId,
            @RequestBody ComplaintRequest request) {

        User user = userService.findById(userId);
        Complaint complaint = complaintService.submitComplaint(request, user);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(complaint);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Complaint>> getComplaintsForUser(
            @PathVariable Long userId) {

        User user = userService.findById(userId);
        return ResponseEntity.ok(
                complaintService.getComplaintsForUser(user));
    }

    @GetMapping("/prioritized")
    public ResponseEntity<List<Complaint>> getPrioritizedComplaints() {
        return ResponseEntity.ok(
                complaintService.getPrioritizedComplaints());
    }
}
