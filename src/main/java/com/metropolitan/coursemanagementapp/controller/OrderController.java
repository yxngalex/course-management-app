package com.metropolitan.coursemanagementapp.controller;

import com.metropolitan.coursemanagementapp.entity.Order;
import com.metropolitan.coursemanagementapp.entity.OrderDetails;
import com.metropolitan.coursemanagementapp.service.OrderDetailsService;
import com.metropolitan.coursemanagementapp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final OrderDetailsService orderDetailsService;

    /*
        Cuvati Order u bazi, kao i taj order u order-details sa sve userom (nalazi se u order) i coursom
     */
    @PostMapping("/")
    public String saveOrder(@ModelAttribute("order") Order order, @ModelAttribute("course") String courseName) {
        orderService.saveOrder(order);

        OrderDetails orderDetails = new OrderDetails();
//        orderDetails.setOrder(order);
//        orderDetails.setCourse();
        orderDetailsService.saveOrderDetail(orderDetails);

        return "redirect:/user/order/";
    }

}
