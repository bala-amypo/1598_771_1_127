package com.example.demo.service.impl;

import com.example.demo.dto.ComplaintRequest;
import com.example.demo.entity.Complaint;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ComplaintRepository;
import com.example.demo.service.ComplaintService;
import com.example.demo.service.PriorityRuleService;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    private final ComplaintRepository complaintRepository;
    private final PriorityRuleService priorityRuleService;
    private final UserService userService;

    public ComplaintServiceImpl(ComplaintRepository complaintRepository,
                                PriorityRuleService priorityRuleService,
                                UserService userService) {
        this.complaintRepository = complaintRepository;
        this.priorityRuleService = priorityRuleService;
        this.userService = userService;
    }

    @Override
    public Complaint submitComplaint(ComplaintRequest request) {
        User user = userService.findById(request.getUserId());

        Complaint complaint = new Complaint();
        complaint.setTitle(request.getTitle());
        complaint.setDescription(request.getDescription());
        complaint.setCategory(request.getCategory());
        complaint.setUser(user);

        int priority = priorityRuleService.calculatePriority(request.getCategory());
        complaint.setPriorityScore(priority);

        return complaintRepository.save(complaint);
    }

    @Override
    public List<Complaint> getUserComplaints(Long userId) {
        User user = userService.findById(userId);
        return complaintRepository.findByUser(user);
    }

    @Override
    public List<Complaint> getPrioritizedComplaints() {
        return complaintRepository.findAllOrderByPriorityScoreDescCreatedAtAsc();
    }

    @Override
    public Complaint updateComplaintStatus(Long id, String status) {
        Complaint complaint = complaintRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Complaint not found"));

        // status stored via ComplaintStatusService (next step) OR simple field
        return complaintRepository.save(complaint);
    }
}
