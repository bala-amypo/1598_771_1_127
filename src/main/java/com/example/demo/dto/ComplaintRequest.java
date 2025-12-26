package com.example.demo.dto;

import com.example.demo.entity.enums.Severity;
import com.example.demo.entity.enums.Urgency;
import lombok.Data;

@Data
public class ComplaintRequest {

    private String title;
    private String description;
    private String category;
    private String channel;
    private Severity severity;
    private Urgency urgency;
}
