package com.example.demo.repository;

import com.example.demo.entity.PriorityRule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PriorityRuleRepository extends JpaRepository<PriorityRule, Long> {

    Optional<PriorityRule> findByCategory(String category);
}
