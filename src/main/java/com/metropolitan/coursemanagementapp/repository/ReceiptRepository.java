package com.metropolitan.coursemanagementapp.repository;

import com.metropolitan.coursemanagementapp.entity.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Integer> {
}
