package com.metropolitan.coursemanagementapp.controller;

import com.metropolitan.coursemanagementapp.entity.*;
import com.metropolitan.coursemanagementapp.service.ReceiptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
@RequestMapping("/receipt")
public class ReceiptController {
    private final ReceiptService receiptService;

    @PostMapping()
    public String saveReceipt(@RequestParam("order_details") OrderDetails orderDetails, Model model) {

        LocalDate date = LocalDate.now();
        Receipt receipt = new Receipt();
        receipt.setOrderDetails(orderDetails);
        receipt.setDate(date);
        receiptService.saveReceipt(receipt);

        model.addAttribute("receipt", receipt);

        return "user/receipt";
    }

}
