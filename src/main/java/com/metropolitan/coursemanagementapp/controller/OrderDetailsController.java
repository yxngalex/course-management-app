package com.metropolitan.coursemanagementapp.controller;

import com.metropolitan.coursemanagementapp.entity.OrderDetails;
import com.metropolitan.coursemanagementapp.service.OrderDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/order_details")
@RequiredArgsConstructor
public class OrderDetailsController {
    private final OrderDetailsService orderDetailsService;

    @GetMapping()
    public String getAllOrderDetails(Model model) {
        List<OrderDetails> orderDetailsList = orderDetailsService.getAllOrderDetails();
        model.addAttribute("getAllOrderDetails", orderDetailsList.get(orderDetailsList.size() - 1));
        return "user/order";
    }

}
