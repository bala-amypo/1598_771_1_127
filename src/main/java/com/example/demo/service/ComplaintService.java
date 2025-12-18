package com.example.demo.service;

import com.example.demo.entity.Complaint;
import java.util.List;

public interface ComplaintService {
    Complaint submitComplaint(String title, String desc, String category, Long userId);
    List<Complaint> getUserComplaints(Long userId);
    List<Complaint> getPrioritizedComplaints();
    void updateComplaintStatus(Long id, String status);
}
