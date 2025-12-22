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

        // severity score
        switch (complaint.getSeverity()) {
            case LOW -> score += 10;
            case MEDIUM -> score += 20;
            case HIGH -> score += 30;
            case CRITICAL -> score += 50;
        }

        // urgency score
        switch (complaint.getUrgency()) {
            case LOW -> score += 5;
            case MEDIUM -> score += 10;
            case HIGH -> score += 20;
            case IMMEDIATE -> score += 40;
        }

        // active rule weights
        for (PriorityRule rule : priorityRuleRepository.findByActiveTrue()) {
            score += rule.getWeight();
        }

        return Math.max(score, 0);
    }

    @Override
    public List<PriorityRule> getActiveRules() {
        return priorityRuleRepository.findByActiveTrue();
    }
}
