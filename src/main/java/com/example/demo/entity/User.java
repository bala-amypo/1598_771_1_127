package com.example.demo.entity;

public class User {
    private Long id;
    private String name;
    private String email;
    private String password;
}




package com.example.demo.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String category;
    private Integer priorityScore;

    private LocalDateTime submittedOn;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @PrePersist
    public void onCreate() {
        this.submittedOn = LocalDateTime.now();
    }
}
