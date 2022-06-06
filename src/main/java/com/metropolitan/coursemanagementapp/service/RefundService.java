package com.metropolitan.coursemanagementapp.service;

import com.metropolitan.coursemanagementapp.entity.Refund;

import java.util.List;

public interface RefundService {
    List<Refund> getAllRefunds();

    Refund getRefundById(Integer refundId);

    Refund saveRefund(Refund refund);

    Refund updateRefund(Refund refund);

    void deleteById(Integer refundId);
}
