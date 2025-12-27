package com.example.demo.repository;

import com.example.demo.entity.ComplaintStatus;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintStatusRepository
        extends JpaRepository<ComplaintStatus, Long> {

    List<ComplaintStatus> findByComplaintId(Long complaintId);
}
