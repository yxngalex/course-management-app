package com.metropolitan.coursemanagementapp.service.impl;

import com.metropolitan.coursemanagementapp.entity.Receipt;
import com.metropolitan.coursemanagementapp.repository.ReceiptRepository;
import com.metropolitan.coursemanagementapp.service.ReceiptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ReceiptServiceImpl implements ReceiptService {

    private final ReceiptRepository receiptRepository;
    @Override
    public List<Receipt> getAllReceipts() {
        return receiptRepository.findAll();
    }

    @Override
    public Receipt getReceiptById(Integer receiptId) {
        return receiptRepository.findById(receiptId)
                .orElseThrow(() -> new NoSuchElementException("ReceiptService.notFound"));
    }

    @Override
    public Receipt saveReceipt(Receipt receipt) {
        return receiptRepository.save(receipt);
    }

    @Override
    public Receipt updateReceipt(Receipt receipt) {
        return receiptRepository.save(receipt);
    }

    @Override
    public void deleteById(Integer receiptId) {
        receiptRepository.deleteById(receiptId);
    }
}
