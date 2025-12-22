package com.example.demo.service;

import com.example.demo.entity.PriorityRule;
import java.util.List;

public interface PriorityRuleService {

    int calculatePriority(String category);

    List<PriorityRule> getAllRules();
}
