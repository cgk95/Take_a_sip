package com.example.myapi.Order.Service;

import com.example.myapi.Order.Repository.OrderRepository;
import com.example.myapi.Products.Repository.BeverageRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final BeverageRepository beverageRepository;

    public OrderService(OrderRepository orderRepository, BeverageRepository beverageRepository) {
        this.orderRepository=orderRepository;
        this.beverageRepository = beverageRepository;

    }
}
