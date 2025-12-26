package com.example.demo.service;

import com.example.demo.entity.ComplaintStatus;

import java.util.List;

public interface ComplaintStatusService {

    ComplaintStatus addStatus(ComplaintStatus status);

    List<ComplaintStatus> getStatusByComplaintId(Long complaintId);
}
