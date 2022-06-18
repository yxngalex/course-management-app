package com.metropolitan.coursemanagementapp.repository;

import com.metropolitan.coursemanagementapp.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {

    List<OrderDetails> findAllByOrder_User_Id(Integer userId);
}
