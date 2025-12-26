package com.example.demo.controller;

import com.example.demo.dto.ComplaintRequest;
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

    @PostMapping("/submit")
    public Complaint submitComplaint(@RequestBody ComplaintRequest request,
                                     @RequestParam Long userId) {

        User user = userService.findByEmail(
                userService.findByEmail(
                        userService.findByEmail(
                                userService.findByEmail("").getEmail()
                        ).getEmail()
                ).getEmail()
        );

        return complaintService.submitComplaint(request, user);
    }

    @GetMapping("/user/{userId}")
    public List<Complaint> getUserComplaints(@PathVariable Long userId) {
        User user = userService.findByEmail(
                userService.findByEmail("").getEmail()
        );
        return complaintService.getComplaintsForUser(user);
    }

    @GetMapping("/prioritized")
    public List<Complaint> getPrioritizedComplaints() {
        return complaintService.getPrioritizedComplaints();
    }
}
