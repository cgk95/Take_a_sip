package com.example.myapi.Entity;
import com.example.myapi.Order.Order;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Repository
@NoArgsConstructor
@Getter
@Table(name = "beverage")
public class Beverage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "beverage_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(mappedBy = "beverage", cascade = CascadeType.ALL)
    private List<Option> options = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @Builder
    public Beverage(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void addOption(Option option) {
        options.add(option);
        option.setBeverage(this);
    }

    public void removeOption(Option option) { // TODO :: 옵션 항목을 제거하는 기능 구현하기
        options.remove(option);
        option.setBeverage(null);
    }

}
