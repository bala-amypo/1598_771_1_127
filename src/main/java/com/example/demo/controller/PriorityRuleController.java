package com.example.demo.controller;

import com.example.demo.entity.PriorityRule;
import com.example.demo.service.PriorityRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/priority-rules")
public class PriorityRuleController {

    private final PriorityRuleService priorityRuleService;

    public PriorityRuleController(PriorityRuleService priorityRuleService) {
        this.priorityRuleService = priorityRuleService;
    }

    @PostMapping
    public PriorityRule createRule(@RequestBody PriorityRule rule) {
        return priorityRuleService.createRule(rule);
    }

    @GetMapping
    public List<PriorityRule> getAllRules() {
        return priorityRuleService.getAllRules();
    }

    @GetMapping("/active")
    public List<PriorityRule> getActiveRules() {
        return priorityRuleService.getActiveRules();
    }
}
