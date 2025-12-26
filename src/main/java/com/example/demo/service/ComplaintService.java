package com.example.demo.service;

import com.example.demo.entity.Complaint;
import java.util.List;

public interface ComplaintService {

    Complaint createComplaint(Complaint complaint);

    // ✅ REQUIRED (tests expect this)
    List<Complaint> getPrioritizedComplaints();
}
