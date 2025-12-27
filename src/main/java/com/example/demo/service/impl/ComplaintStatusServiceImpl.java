package com.example.demo.service.impl;

import com.example.demo.entity.Complaint;
import com.example.demo.entity.ComplaintStatus;
import com.example.demo.repository.ComplaintRepository;
import com.example.demo.repository.ComplaintStatusRepository;
import com.example.demo.service.ComplaintStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ComplaintStatusServiceImpl implements ComplaintStatusService {

    @Autowired
    private ComplaintStatusRepository obj;

    @Autowired
    private ComplaintRepository complaintObj;

    public void updateStatus(Long complaintId, String status) {
        Complaint complaint = complaintObj.findById(complaintId).orElseThrow();
        ComplaintStatus cs = new ComplaintStatus();
        cs.setComplaint(complaint);
        cs.setStatus(status);
        obj.save(cs);
    }

    public List<ComplaintStatus> getStatusHistory(Long complaintId) {
        return obj.findByComplaintId(complaintId);
    }
}
