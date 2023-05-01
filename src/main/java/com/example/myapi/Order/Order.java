package com.example.myapi.Order;

import javax.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;


    private LocalDateTime orderDateTime; // 주문시간


}
