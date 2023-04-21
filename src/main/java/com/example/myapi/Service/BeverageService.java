package com.example.myapi.Service;

import com.example.myapi.Repository.Entity.Beverage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeverageService {
    private final Beverage beverage;
    @Autowired
    public BeverageService(Beverage beverage) {
        this.beverage = beverage;
    }

}
