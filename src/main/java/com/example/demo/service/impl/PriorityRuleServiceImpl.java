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

    // ✅ REQUIRED by PriorityRuleService
    @Override
    public List<PriorityRule> getActiveRules() {
        return priorityRuleRepository.findByActiveTrue();
    }

    // ✅ Used by ComplaintService
    @Override
    public int computePriorityScore(Complaint complaint) {

        int score = 0;

        List<PriorityRule> rules = getActiveRules();

        for (PriorityRule rule : rules) {
            score += rule.getWeight();
        }

        return score;
    }
}
