package com.example.myapi.Order.Controller;


import java.time.LocalDateTime;
import java.util.List;

import com.example.myapi.Products.Controller.BeverageDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
public class OrderDTO {
    private List<BeverageDTO> orderList;

    private LocalDateTime orderDateTime;
}
