package com.example.myapi.Order.Controller;

import com.example.myapi.Entity.Order;
import com.example.myapi.Order.Service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderDTO requestDTO) {
        Order order = orderService.createOrder(requestDTO);
        return ResponseEntity.ok(order);
    }
}
