package com.example.myapi.Products.Controller;

import com.example.myapi.Entity.Beverage;
import com.example.myapi.Products.Service.BeverageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class BeverageController {
    private final BeverageService beverageService;

    @GetMapping("/get/All")
    public ResponseEntity<List<Beverage>> getAllBeverage() {
        return ResponseEntity.ok(beverageService.getAllBeverages());
    }

    @GetMapping("/get/{name}")
    public ResponseEntity<Beverage> getBeverageByName(@PathVariable String name) {
        Beverage beverage = beverageService.findBeverageByName(name).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 음료 이름입니다."));
        if (beverage == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(beverage);
    }

    @PostMapping(value="/addBeverage")
    public ResponseEntity<BeverageDTO> addBeverage(@RequestBody BeverageDTO beverageDTO) {
        beverageService.addBeverage(beverageDTO);
        return ResponseEntity.ok().build();
    }

}
