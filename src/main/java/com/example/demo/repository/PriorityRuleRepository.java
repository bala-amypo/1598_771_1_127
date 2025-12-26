package com.example.demo.repository;

import com.example.demo.entity.PriorityRule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PriorityRuleRepository extends JpaRepository<PriorityRule, Long> {

    List<PriorityRule> findByActiveTrue();

    Optional<PriorityRule> findByCategory(String category);
}
