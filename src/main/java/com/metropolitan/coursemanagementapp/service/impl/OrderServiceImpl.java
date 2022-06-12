package com.metropolitan.coursemanagementapp.service.impl;

import com.metropolitan.coursemanagementapp.entity.Order;
import com.metropolitan.coursemanagementapp.repository.OrderRepository;
import com.metropolitan.coursemanagementapp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Integer orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new NoSuchElementException("OrderService.notFound"));
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteById(Integer orderId) {
        orderRepository.deleteById(orderId);
    }
}
