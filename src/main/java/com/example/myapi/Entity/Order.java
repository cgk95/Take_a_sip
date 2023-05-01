package com.example.myapi.Entity;
import com.example.myapi.Entity.Beverage;
import javax.persistence.*;

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

    // TODO :: ITEM 추상 클래스를 엔티티로 선언하여, 그를 상속받은 상세 엔티티를 만드는 방식으로 바꾸기 >> 그를 통해서 orderList의 반환값이 List<ITEM> 이 되도록 변경하기
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Beverage> orderList = new ArrayList<>();

    private LocalDateTime orderDateTime; // 주문시간


}
