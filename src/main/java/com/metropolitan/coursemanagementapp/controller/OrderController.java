package com.metropolitan.coursemanagementapp.controller;

import com.metropolitan.coursemanagementapp.entity.Course;
import com.metropolitan.coursemanagementapp.entity.Order;
import com.metropolitan.coursemanagementapp.entity.OrderDetails;
import com.metropolitan.coursemanagementapp.entity.User;
import com.metropolitan.coursemanagementapp.service.OrderDetailsService;
import com.metropolitan.coursemanagementapp.service.OrderService;
import com.metropolitan.coursemanagementapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.sql.Date;

@Controller
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final OrderDetailsService orderDetailsService;
    private final UserService userService;

    /*
        Cuvati Order u bazi, kao i taj order u order-details sa sve userom (nalazi se u order) i cours-om
     */
    @PostMapping("/")
    public String saveOrder(@RequestParam("course") Course course, @RequestParam("username") String username) {

        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        User user = userService.getUserByUsername(username);

        Order order = new Order();
        order.setUser(user);
        order.setDate(date);
        orderService.saveOrder(order);

        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setOrder(order);
        orderDetails.setCourse(course);
        orderDetails.setPrice(course.getPrice());
        orderDetailsService.saveOrderDetail(orderDetails);

        return "redirect:../order_details/";
    }

}
