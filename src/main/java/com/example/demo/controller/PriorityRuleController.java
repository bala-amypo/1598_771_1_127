package com.example.demo.controller;

import com.example.demo.entity.PriorityRule;
import com.example.demo.service.PriorityRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rules")
public class PriorityRuleController {

    private final PriorityRuleService priorityRuleService;

    // Constructor injection ONLY
    public PriorityRuleController(PriorityRuleService priorityRuleService) {
        this.priorityRuleService = priorityRuleService;
    }

    /**
     * Get all ACTIVE priority rules
     * URL: GET /rules/all
     */
    @GetMapping("/all")
    public List<PriorityRule> getAllActiveRules() {
        return priorityRuleService.getActiveRules();
    }
}
