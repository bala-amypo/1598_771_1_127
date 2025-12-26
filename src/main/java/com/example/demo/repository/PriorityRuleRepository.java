package com.example.demo.repository;

import com.example.demo.entity.PriorityRule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PriorityRuleRepository extends JpaRepository<PriorityRule, Long> {

    // ❌ REMOVE this (causes crash)
    // Optional<PriorityRule> findByCategory(String category);

    // ✅ REQUIRED by service + tests
    List<PriorityRule> findByActiveTrue();
}
