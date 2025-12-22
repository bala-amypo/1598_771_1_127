package com.example.demo.service.impl;

import com.example.demo.entity.PriorityRule;
import com.example.demo.repository.PriorityRuleRepository;
import com.example.demo.service.PriorityRuleService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PriorityRuleServiceImpl implements PriorityRuleService {

    private final PriorityRuleRepository priorityRuleRepository;

    // Constructor injection (MANDATORY)
    public PriorityRuleServiceImpl(PriorityRuleRepository priorityRuleRepository) {
        this.priorityRuleRepository = priorityRuleRepository;
    }

    @Override
    public int calculatePriority(String category) {
        return priorityRuleRepository.findByCategory(category)
                .map(PriorityRule::getBaseScore)
                .orElse(0);
    }

    @Override
    public List<PriorityRule> getAllRules() {
        return priorityRuleRepository.findAll();
    }
}
