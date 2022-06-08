package com.metropolitan.coursemanagementapp.service;

import com.metropolitan.coursemanagementapp.entity.OrderDetails;

import java.util.List;

public interface OrderDetailsService {

    List<OrderDetails> getAllOrderDetails();

    OrderDetails getOrderDetailById(Integer orderDetailId);

    OrderDetails saveOrderDetail(OrderDetails orderDetails);

    OrderDetails updateOrderDetail(OrderDetails orderDetails);

    void deleteById(Integer orderDetailId);

}
