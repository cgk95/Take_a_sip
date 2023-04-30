package com.example.myapi.Order;

import javax.persistence.*;

import com.example.myapi.Products.Repository.Entity.Beverage;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Beverage>  orderBeverage = new ArrayList<>(); // 주문할 음료 리스트

    private LocalDateTime orderDateTime; // 주문시간


}
