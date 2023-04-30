package com.example.myapi.Products.Controller;

import com.example.myapi.Products.Repository.Size;
import com.example.myapi.Products.Repository.Temperature;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class OptionDTO {
    private String size;
    private String temperature;
    private BigDecimal price;

    public OptionDTO(Size size, Temperature temperature, BigDecimal price) {
        this.size = size.name(); // Enum을 이용한 String으로 넘기기
        this.temperature = temperature.name();
        this.price = price;
    }
}