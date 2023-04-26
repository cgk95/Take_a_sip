package com.example.myapi.Service;

import com.example.myapi.Repository.BeverageRepository;
import com.example.myapi.Repository.Entity.Beverage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeverageService {
    private final BeverageRepository beverageRepository;

    @Autowired
    public BeverageService(BeverageRepository beverageRepository) {
        this.beverageRepository = beverageRepository;
    }

    public List<Beverage> getAllBeverages() {
        return beverageRepository.findAll();
    }

    public Beverage findBeverageByName(String name) {
        return this.beverageRepository.findBeverageByName(name);
    }
}
