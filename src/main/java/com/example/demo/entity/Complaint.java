package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Complaint {

    public enum Status {
        NEW, OPEN, IN_PROGRESS, RESOLVED
    }

    public enum Severity {
        LOW, MEDIUM, HIGH, CRITICAL
    }

    public enum Urgency {
        LOW, MEDIUM, HIGH, IMMEDIATE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String category;
    private String channel;

    private Integer priorityScore;

    @Enumerated(EnumType.STRING)
    private Status status = Status.NEW;

    @Enumerated(EnumType.STRING)
    private Severity severity;

    @Enumerated(EnumType.STRING)
    private Urgency urgency;

    private LocalDateTime createdAt;

    @ManyToOne(optional = false)
    private User customer;

    @ManyToOne
    private User assignedAgent;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // getters and setters
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getCategory() { return category; }
    public String getChannel() { return channel; }
    public Integer getPriorityScore() { return priorityScore; }
    public Status getStatus() { return status; }
    public Severity getSeverity() { return severity; }
    public Urgency getUrgency() { return urgency; }
    public User getCustomer() { return customer; }

    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setCategory(String category) { this.category = category; }
    public void setChannel(String channel) { this.channel = channel; }
    public void setPriorityScore(Integer priorityScore) { this.priorityScore = priorityScore; }
    public void setStatus(Status status) { this.status = status; }
    public void setSeverity(Severity severity) { this.severity = severity; }
    public void setUrgency(Urgency urgency) { this.urgency = urgency; }
    public void setCustomer(User customer) { this.customer = customer; }
    public void setAssignedAgent(User assignedAgent) { this.assignedAgent = assignedAgent; }
}
