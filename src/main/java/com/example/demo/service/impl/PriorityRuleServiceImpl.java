package com.example.demo.service.impl;

import com.example.demo.entity.Complaint;
import com.example.demo.entity.PriorityRule;
import com.example.demo.repository.PriorityRuleRepository;
import com.example.demo.service.PriorityRuleService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service   
public class PriorityRuleServiceImpl implements PriorityRuleService {

    private final PriorityRuleRepository priorityRuleRepository;

    public PriorityRuleServiceImpl(PriorityRuleRepository priorityRuleRepository) {
        this.priorityRuleRepository = priorityRuleRepository;
    }

    @Override
    public int computePriorityScore(Complaint complaint) {

        int score = 0;

        if (complaint.getSeverity() == Complaint.Severity.CRITICAL) {
            score += 50;
        }
        if (complaint.getUrgency() == Complaint.Urgency.IMMEDIATE) {
            score += 40;
        }

        List<PriorityRule> rules = priorityRuleRepository.findByActiveTrue();
        for (PriorityRule rule : rules) {
            score += rule.getWeight();
        }

        return Math.max(score, 1);
    }

    @Override
    public List<PriorityRule> getActiveRules() {
        return priorityRuleRepository.findByActiveTrue();
    }
}
