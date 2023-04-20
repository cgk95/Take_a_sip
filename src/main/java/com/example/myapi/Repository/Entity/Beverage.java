package com.example.myapi.Repository.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@Getter
@Table(name = "beverage") // 가장 하위의 아이템(음료) 정보를 담음
public class Beverage {
    /**
     * 음료를 표현할 기본 키 :: 자동으로 증가
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "beverage_id")
    private Long id;

    /**
     * 음료 이름
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * 음료에 대한 간단한 설명
     */
    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(mappedBy = "beverage", cascade = CascadeType.ALL)
    private List<Option> options = new ArrayList<>();

    public void addOption(Option option) {
        options.add(option);
        option.setBeverage(this);
    }

    public void removeOption(Option option) {
        options.remove(option);
        option.setBeverage(null);
    }

}
