package com.example.demo.service;

import com.example.demo.entity.Complaint;
import com.example.demo.entity.ComplaintStatus;

import java.util.List;

public interface ComplaintStatusService {

    ComplaintStatus updateStatus(Complaint complaint, Complaint.Status status);

    List<ComplaintStatus> getStatusHistory(Complaint complaint);
}
