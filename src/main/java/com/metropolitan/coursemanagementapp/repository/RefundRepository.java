package com.metropolitan.coursemanagementapp.repository;

import com.metropolitan.coursemanagementapp.entity.Refund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefundRepository extends JpaRepository<Refund, Integer> {
}
