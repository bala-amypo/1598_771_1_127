package com.example.demo.service.impl;

import com.example.demo.entity.Complaint;
import com.example.demo.entity.User;
import com.example.demo.exception.ComplaintNotFoundException;
import com.example.demo.repository.ComplaintRepository;
import com.example.demo.service.ComplaintService;
import com.example.demo.service.PriorityRuleService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    private final ComplaintRepository complaintRepository;
    private final PriorityRuleService priorityRuleService;

    // Constructor injection ONLY
    public ComplaintServiceImpl(ComplaintRepository complaintRepository,
                                PriorityRuleService priorityRuleService) {
        this.complaintRepository = complaintRepository;
        this.priorityRuleService = priorityRuleService;
    }

    @Override
    public Complaint submitComplaint(Complaint complaint, User customer) {

        complaint.setCustomer(customer);

        // compute priority score using PriorityRuleService
        int score = priorityRuleService.computePriorityScore(complaint);
        complaint.setPriorityScore(score);

        return complaintRepository.save(complaint);
    }

    @Override
    public List<Complaint> getComplaintsForUser(User customer) {
        return complaintRepository.findByCustomer(customer);
    }

    @Override
    public List<Complaint> getPrioritizedComplaints() {
        return complaintRepository.findAllOrderByPriorityScoreDescCreatedAtAsc();
    }

    @Override
    public Complaint updateStatus(Long complaintId, Complaint.Status status) {
        Complaint complaint = complaintRepository.findById(complaintId)
                .orElseThrow(() ->
                        new ComplaintNotFoundException("Complaint not found"));

        complaint.setStatus(status);
        return complaintRepository.save(complaint);
    }
}
