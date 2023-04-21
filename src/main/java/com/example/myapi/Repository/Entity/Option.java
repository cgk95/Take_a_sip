package com.example.myapi.Repository.Entity;

import com.example.myapi.Repository.Size;
import com.example.myapi.Repository.Temperature;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "beverage_id")
    private Beverage beverage;

    @Builder
    public Option(Size size, Temperature temperature) {
        this.size = size;
        this.temperature = temperature;
    }

    public void setBeverage(Beverage beverage) {
        this.beverage = beverage;
    }

}

