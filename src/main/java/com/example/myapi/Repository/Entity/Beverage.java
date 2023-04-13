package com.example.myapi.Repository.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "berverage")
public class Beverage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "berverage_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private String hotOrIced;

    @Column(nullable = false)
    private String size; // 세가지 선택지가 있는 경우 String이 낫나, 정수 기반으로 분류하는게 낫나...?

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Boolean takeOut; // true면 테이크아웃

//    @Column :: 컬럼 너무 많다, 내가 감당 못함
//    private Boolean decaffein;
    @Builder
    public Beverage(String name,String description,String hotOrIced,String size,Integer price,Boolean takeOut){
        this.name=name;
        this.description=description;
        this.hotOrIced=hotOrIced;
        this.size=size;
        this.price=price;
        this.takeOut=takeOut;
    }
}
