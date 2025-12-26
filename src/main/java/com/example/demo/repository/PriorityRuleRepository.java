package com.example.demo.repository;

import com.example.demo.entity.PriorityRule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PriorityRuleRepository extends JpaRepository<PriorityRule, Long> {

    // ✅ REQUIRED by service & tests
    List<PriorityRule> findByActiveTrue();

    // ❌ REMOVE if present
    // Optional<PriorityRule> findByCategory(String category);
}
