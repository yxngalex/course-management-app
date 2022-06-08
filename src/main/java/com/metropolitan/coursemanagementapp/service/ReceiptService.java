package com.metropolitan.coursemanagementapp.service;

import com.metropolitan.coursemanagementapp.entity.Receipt;

import java.util.List;

public interface ReceiptService {

    List<Receipt> getAllReceipts();

    Receipt getReceiptById(Integer receiptId);

    Receipt saveReceipt(Receipt receipt);

    Receipt updateReceipt(Receipt receipt);

    void deleteById(Integer receiptId);
}
