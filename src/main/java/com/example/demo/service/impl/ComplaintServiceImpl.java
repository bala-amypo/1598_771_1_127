package com.example.demo.service.impl;

import com.example.demo.dto.ComplaintRequest;
import com.example.demo.entity.Complaint;
import com.example.demo.entity.PriorityRule;
import com.example.demo.entity.User;
import com.example.demo.repository.ComplaintRepository;
import com.example.demo.service.ComplaintService;
import com.example.demo.service.PriorityRuleService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    private final ComplaintRepository complaintRepository;
    private final PriorityRuleService priorityRuleService;

    public ComplaintServiceImpl(
            ComplaintRepository complaintRepository,
            PriorityRuleService priorityRuleService
    ) {
        this.complaintRepository = complaintRepository;
        this.priorityRuleService = priorityRuleService;
    }

    @Override
    public Complaint createComplaint(Complaint complaint) {
        complaint.setPriorityScore(calculatePriorityScore());
        return complaintRepository.save(complaint);
    }

    @Override
    public List<Complaint> getPrioritizedComplaints() {
        List<Complaint> complaints = complaintRepository.findAll();
        complaints.sort(
                Comparator.comparingInt(Complaint::getPriorityScore).reversed()
        );
        return complaints;
    }

    @Override
    public Complaint submitComplaint(ComplaintRequest request, User user) {
        Complaint complaint = new Complaint();
        complaint.setTitle(request.getTitle());
        complaint.setDescription(request.getDescription());
        complaint.setCategory(request.getCategory());
        complaint.setChannel(request.getChannel());
        complaint.setSeverity(request.getSeverity());
        complaint.setUrgency(request.getUrgency());
        complaint.setStatus(request.getStatus());
        complaint.setCustomer(user);
        return createComplaint(complaint);
    }

    @Override
    public List<Complaint> getComplaintsForUser(User user) {
        return complaintRepository.findByCustomer(user);
    }

    private int calculatePriorityScore() {
        return priorityRuleService.getActiveRules()
                .stream()
                .mapToInt(PriorityRule::getWeight)
                .sum();
    }
}
