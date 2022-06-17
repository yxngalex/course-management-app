package com.metropolitan.coursemanagementapp.service.impl;

import com.metropolitan.coursemanagementapp.entity.OrderDetails;
import com.metropolitan.coursemanagementapp.repository.OrderDetailsRepository;
import com.metropolitan.coursemanagementapp.service.OrderDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class OrderDetailsServiceImpl implements OrderDetailsService {

    private final OrderDetailsRepository orderDetailsRepository;

    @Override
    public List<OrderDetails> getAllOrderDetails() {
        return orderDetailsRepository.findAll();
    }

    @Override
    public OrderDetails getOrderDetailById(Integer orderDetailId) {
        return orderDetailsRepository.findById(orderDetailId)
                .orElseThrow(() -> new NoSuchElementException("OrderDetailService.notFound"));
    }

    @Override
    public OrderDetails saveOrderDetail(OrderDetails orderDetails) {
        return orderDetailsRepository.save(orderDetails);
    }

    @Override
    public OrderDetails updateOrderDetail(OrderDetails orderDetails) {
        return orderDetailsRepository.save(orderDetails);
    }

    @Override
    public void deleteById(Integer orderDetailId) {
        orderDetailsRepository.deleteById(orderDetailId);
    }

    @Override
    public List<OrderDetails> getAllByUserId(Integer userId) {
        return orderDetailsRepository.findAllByOrder_User_Id(userId);
    }
}
