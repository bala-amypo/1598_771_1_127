package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.*;
import org.springframework.stereotype.Service;
import com.example.demo.service.UserService;

import java.util.List;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    private final ComplaintRepository complaintRepo;
    private final PriorityRuleService priorityService;
    private final UserService userService;

    public ComplaintServiceImpl(
            ComplaintRepository complaintRepo,
            PriorityRuleService priorityService,
            UserService userService) {
        this.complaintRepo = complaintRepo;
        this.priorityService = priorityService;
        this.userService = userService;
    }

    public Complaint submitComplaint(String title, String desc, String category, Long userId) {
        User user = userService.findById(userId);

        Complaint c = new Complaint();
        c.setTitle(title);
        c.setDescription(desc);
        c.setCategory(category);
        c.setUser(user);
        c.setPriorityScore(priorityService.calculatePriority(category));

        return complaintRepo.save(c);
    }

    public List<Complaint> getUserComplaints(Long userId) {
        return complaintRepo.findByUserId(userId);
    }

    public List<Complaint> getPrioritizedComplaints() {
        return complaintRepo.findAllOrderByPriorityScoreDescCreatedAtAsc();
    }

    public void updateComplaintStatus(Long id, String status) {
        Complaint c = complaintRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Complaint not found"));
    }
}
