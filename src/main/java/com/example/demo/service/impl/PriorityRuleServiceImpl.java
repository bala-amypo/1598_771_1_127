package com.example.demo.service.impl;

import com.example.demo.entity.Complaint;
import com.example.demo.service.PriorityRuleService;
import org.springframework.stereotype.Service;

@Service
public class PriorityRuleServiceImpl implements PriorityRuleService {

    @Override
    public int computePriorityScore(Complaint complaint) {

        int score = 0;

        // Severity score
        switch (complaint.getSeverity()) {
            case LOW -> score += 10;
            case MEDIUM -> score += 20;
            case HIGH -> score += 30;
            case CRITICAL -> score += 50;
        }

        // Urgency score
        switch (complaint.getUrgency()) {
            case LOW -> score += 5;
            case MEDIUM -> score += 10;
            case HIGH -> score += 20;
            case IMMEDIATE -> score += 40;
        }

        return score;
    }
}
