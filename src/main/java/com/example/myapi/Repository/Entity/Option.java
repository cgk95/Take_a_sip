package com.example.myapi.Repository.Entity;

import com.example.myapi.Repository.Size;
import com.example.myapi.Repository.Temperature;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "option")
@NoArgsConstructor
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Size size;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Temperature temperature;

    @Column(name = "price")
    private BigDecimal price; // Integer 대신 계산 오류 가능성이 적은 BigDecimal 사용한다고 함

    @ManyToOne(fetch = FetchType.LAZY) // 필요할 때만 Fetch 하는 타입
    @JoinColumn(name = "beverage_id")
    private Beverage beverage;

    @Builder
    public Option(Size size, Temperature temperature, BigDecimal price) {
        this.size = size;
        this.temperature = temperature;
        this.price = price;
    }

    public void setBeverage(Beverage beverage) {
        this.beverage = beverage;
    }

}

