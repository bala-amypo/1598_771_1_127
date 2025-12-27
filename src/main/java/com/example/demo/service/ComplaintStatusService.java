package com.example.demo.service;

import com.example.demo.entity.ComplaintStatus;
import java.util.List;

public interface ComplaintStatusService {

    List<ComplaintStatus> getStatusHistory(Long complaintId);
}
