package com.example.demo.service;

import com.example.demo.entity.ComplaintStatus;
import java.util.List;

public interface ComplaintStatusService {

    void updateStatus(Long complaintId, String status);

    List<ComplaintStatus> getStatusHistory(Long complaintId);
}
