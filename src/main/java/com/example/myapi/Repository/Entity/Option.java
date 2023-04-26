package com.example.myapi.Repository.Entity;

import com.example.myapi.Repository.Size;
import com.example.myapi.Repository.Temperature;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "option")
@NoArgsConstructor
@Setter
@Getter
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

    @Column(nullable = false)
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
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

