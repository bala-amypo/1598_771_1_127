package com.example.demo.service;

import com.example.demo.entity.PriorityRule;

import java.util.List;

public interface PriorityRuleService {

    PriorityRule createRule(PriorityRule rule);

    List<PriorityRule> getAllRules();

    // ✅ ADD THIS (controller expects it)
    List<PriorityRule> getActiveRules();
}
