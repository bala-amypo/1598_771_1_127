package com.example.demo.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "complaints")
public class Complaint {

    public enum Status {
        NEW,
        IN_PROGRESS,
        RESOLVED,
        CLOSED
    }

    public enum Severity {
        LOW,
        MEDIUM,
        HIGH,
        CRITICAL
    }

    public enum Urgency {
        LOW,
        MEDIUM,
        HIGH,
        IMMEDIATE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 2000)
    private String description;

    private String category;

    private String channel;

    @Enumerated(EnumType.STRING)
    private Status status = Status.NEW;

    @Enumerated(EnumType.STRING)
    private Severity severity;

    @Enumerated(EnumType.STRING)
    private Urgency urgency;

    private Integer priorityScore = 0;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private User assignedAgent;

    @ManyToMany
    @JoinTable(
            name = "complaint_priority_rules",
            joinColumns = @JoinColumn(name = "complaint_id"),
            inverseJoinColumns = @JoinColumn(name = "rule_id")
    )
    private Set<PriorityRule> priorityRules = new HashSet<>();

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    // ===== Automatically set createdAt =====
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // ===== Getters & Setters =====

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPriorityScore() {
        return priorityScore;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriorityScore(Integer priorityScore) {
        this.priorityScore = priorityScore;
    }

    public String getCategory() {
        return category;
    }

    public String getChannel() {
        return channel;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Status getStatus() {
        return status;
    }

    public Severity getSeverity() {
        return severity;
    }

    public Urgency getUrgency() {
        return urgency;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public void setUrgency(Urgency urgency) {
        this.urgency = urgency;
    }

    public User getCustomer() {
        return customer;
    }

    public User getAssignedAgent() {
        return assignedAgent;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public void setAssignedAgent(User assignedAgent) {
        this.assignedAgent = assignedAgent;
    }

    public Set<PriorityRule> getPriorityRules() {
        return priorityRules;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
