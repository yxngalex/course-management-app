package com.metropolitan.coursemanagementapp.service.impl;

import com.metropolitan.coursemanagementapp.entity.Course;
import com.metropolitan.coursemanagementapp.entity.Refund;
import com.metropolitan.coursemanagementapp.repository.RefundRepository;
import com.metropolitan.coursemanagementapp.service.RefundService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class RefundServiceImpl implements RefundService {
    private final RefundRepository refundRepository;

    @Override
    public List<Refund> getAllRefunds() {
        return refundRepository.findAll();
    }

    @Override
    public Refund getRefundById(Integer refundId) {
        return refundRepository.findById(refundId)
                .orElseThrow(() -> new NoSuchElementException("RefundService.notFound"));
    }

    @Override
    public Refund saveRefund(Refund refund) {
        return refundRepository.save(refund);
    }

    @Override
    public Refund updateRefund(Refund refund) {
        return refundRepository.save(refund);
    }

    @Override
    public void deleteById(Integer refundId) {

    }
}
