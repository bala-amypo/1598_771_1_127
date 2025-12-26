package com.example.demo.service.impl;

import com.example.demo.entity.ComplaintStatus;
import com.example.demo.repository.ComplaintStatusRepository;
import com.example.demo.service.ComplaintStatusService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintStatusServiceImpl implements ComplaintStatusService {

    private final ComplaintStatusRepository complaintStatusRepository;

    public ComplaintStatusServiceImpl(ComplaintStatusRepository complaintStatusRepository) {
        this.complaintStatusRepository = complaintStatusRepository;
    }

    @Override
    public ComplaintStatus addStatus(ComplaintStatus status) {
        return complaintStatusRepository.save(status);
    }

    @Override
    public List<ComplaintStatus> getStatusByComplaintId(Long complaintId) {
        return complaintStatusRepository.findByComplaintId(complaintId);
    }
}
