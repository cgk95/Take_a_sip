package com.example.myapi.Controller;

import com.example.myapi.Repository.Entity.Beverage;
import com.example.myapi.Service.BeverageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/beverage")
public class BeverageController {
    private final BeverageService beverageService;

    @Autowired
    public BeverageController(BeverageService beverageService) {
        this.beverageService = beverageService;
    }

    public List<Beverage> getAllBeverage() {
        return beverageService.getAllBeverages();
    }

    @GetMapping("/{name}")
    public ResponseEntity<Beverage> getBeverageByName(@PathVariable String name) {
        Beverage beverage = beverageService.findBeverageByName(name);
        if (beverage == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(beverage);
    }


}
