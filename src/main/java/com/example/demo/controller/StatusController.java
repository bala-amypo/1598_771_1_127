package com.example.demo.controller;

import com.example.demo.entity.ComplaintStatus;
import com.example.demo.service.ComplaintStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/status")
public class StatusController {

    @Autowired
    private ComplaintStatusService obj;

    @GetMapping("/history/{complaintId}")
    public List<ComplaintStatus> history(@PathVariable Long complaintId) {
        return obj.getStatusHistory(complaintId);
    }
}
