package com.example.myapi.Repository.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor // 매개변수 없는 생성자 자동 생성해줌
@Table(name = "espresso")
public class Espresso { // 에스프레소 류를 모아놓은 게시판이라고 생각하고 설계해야 하겠다...!!
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;
    @ManyToOne(cascade = CascadeType.MERGE, targetEntity = Beverage.class)
    @JoinColumn(name = "berverage_id", updatable = false)
    private Beverage beverage;
    @Column(name = "Espresso")
    String title;
    @Column
    String content; // 하위의 berverage.description과 헷갈리지 않기 위해서 :: 카테고리 설명

    @Builder
    public Espresso(Beverage beverage, String title, String content) {
        this.beverage = beverage;
        this.title=title;
        this.content=content;
    }

}
