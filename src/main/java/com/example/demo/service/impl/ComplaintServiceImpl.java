package com.example.demo.service.impl;

import com.example.demo.dto.ComplaintRequest;
import com.example.demo.entity.Complaint;
import com.example.demo.entity.User;
import com.example.demo.entity.enums.ComplaintStatus;
import com.example.demo.repository.ComplaintRepository;
import com.example.demo.service.ComplaintService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ComplaintServiceImpl implements ComplaintService {

    private final ComplaintRepository complaintRepository;

    @Override
    public Complaint submitComplaint(ComplaintRequest request, User user) {

        Complaint complaint = new Complaint();
        complaint.setTitle(request.getTitle());
        complaint.setDescription(request.getDescription());
        complaint.setCategory(request.getCategory());
        complaint.setChannel(request.getChannel());
        complaint.setSeverity(request.getSeverity());
        complaint.setUrgency(request.getUrgency());

        // ✅ STATUS SET BY SYSTEM (FIX)
        complaint.setStatus(ComplaintStatus.NEW);

        complaint.setCustomer(user);
        complaint.setCreatedAt(LocalDateTime.now());

        return complaintRepository.save(complaint);
    }

    @Override
    public List<Complaint> getComplaintsForUser(User user) {
        return complaintRepository.findByCustomer(user);
    }

    @Override
    public List<Complaint> getPrioritizedComplaints() {
        return complaintRepository.findAllByOrderByPriorityScoreDesc();
    }
}
