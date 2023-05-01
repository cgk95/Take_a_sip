package com.example.myapi.Products.Controller;

import com.example.myapi.Entity.Size;
import com.example.myapi.Entity.Temperature;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
public class OptionDTO {
    private String size;
    private String temperature;
    private BigDecimal price;

    public OptionDTO(Size size, Temperature temperature, BigDecimal price) {
        this.size = size.name();
        this.temperature = temperature.name();
        this.price = price;
    }
}