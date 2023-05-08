package com.example.myapi.Order.Service;

import com.example.myapi.Entity.Beverage;
import com.example.myapi.Entity.Order;
import com.example.myapi.Order.Controller.OrderDTO;
import com.example.myapi.Order.Repository.OrderRepository;
import com.example.myapi.Products.Controller.BeverageDTO;
import com.example.myapi.Products.Repository.BeverageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final BeverageRepository beverageRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, BeverageRepository beverageRepository) {
        this.orderRepository = orderRepository;
        this.beverageRepository = beverageRepository;
    }

    public Order createOrder(OrderDTO requestDTO) {
        List<Beverage> orderList = new ArrayList<>();
        Order order = new Order(orderList, LocalDateTime.now());
        for (BeverageDTO beverageDTO : requestDTO.getOrderList()) {
            Beverage beverage = Optional.ofNullable(beverageRepository.findBeverageByName(beverageDTO.getName()))
                    .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 음료 이름입니다."));
            orderList.add(beverage);
        }
        return orderRepository.save(order);
    }
}
