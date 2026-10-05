package org.evanke.springbootmall.controller;

import jakarta.validation.Valid;
import org.evanke.springbootmall.dto.CreateOrderRerquest;
import org.evanke.springbootmall.model.Order;
import org.evanke.springbootmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/users/{userId}/orders")
    public ResponseEntity<?> createOrder(@PathVariable Integer userId,
                                         @RequestBody @Valid CreateOrderRerquest createOrderRerquest) {

        Integer orderId = orderService.createOrder(userId, createOrderRerquest);
        Order order = orderService.getOrderById(orderId);

        return ResponseEntity.ok().body(order);

    }
}
