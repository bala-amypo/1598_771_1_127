package com.example.demo.controller;

import com.example.demo.repository.PriorityRuleRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rules")
public class PriorityRuleController {

    private final PriorityRuleRepository repo;

    public PriorityRuleController(PriorityRuleRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/all")
    public Object allRules() {
        return repo.findAll();
    }
}
