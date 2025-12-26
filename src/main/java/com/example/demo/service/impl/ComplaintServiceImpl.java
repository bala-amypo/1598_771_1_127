package com.example.demo.service.impl;

import com.example.demo.entity.Complaint;
import com.example.demo.entity.PriorityRule;
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

    // ✅ Constructor EXACTLY as tests expect
    public ComplaintServiceImpl(
            ComplaintRepository complaintRepository,
            PriorityRuleService priorityRuleService
    ) {
        this.complaintRepository = complaintRepository;
        this.priorityRuleService = priorityRuleService;
    }

    @Override
    public Complaint createComplaint(Complaint complaint) {
        int score = calculatePriorityScore();
        complaint.setPriorityScore(score);
        return complaintRepository.save(complaint);
    }

    // ✅ REQUIRED BY INTERFACE + TESTS
    @Override
    public List<Complaint> getPrioritizedComplaints() {
        List<Complaint> complaints = complaintRepository.findAll();
        complaints.sort(
                Comparator.comparingInt(Complaint::getPriorityScore).reversed()
        );
        return complaints;
    }

    // 🔒 Internal helper (NO @Override here)
    private int calculatePriorityScore() {
        int score = 0;
        List<PriorityRule> rules = priorityRuleService.getActiveRules();
        for (PriorityRule rule : rules) {
            score += rule.getWeight();
        }
        return score;
    }
}
