package com.metropolitan.coursemanagementapp.repository;

import com.metropolitan.coursemanagementapp.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {
}
