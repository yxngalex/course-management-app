package com.metropolitan.coursemanagementapp.service;

import com.metropolitan.coursemanagementapp.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();

    Order getOrderById(Integer orderId);

    Order saveOrder(Order order);

    Order updateOrder(Order order);

    void deleteById(Integer orderId);
}
