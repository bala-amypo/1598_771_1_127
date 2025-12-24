package com.example.demo.repository;

import com.example.demo.entity.Complaint;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

    List<Complaint> findByUser(User user);

    @Query("SELECT c FROM Complaint c ORDER BY c.priorityScore DESC, c.submittedOn ASC")
    List<Complaint> findAllOrderByPriorityScoreDescCreatedAtAsc();
}
