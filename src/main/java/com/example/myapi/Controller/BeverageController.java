package com.example.myapi.Controller;

import com.example.myapi.Repository.Entity.Beverage;
import com.example.myapi.Service.BeverageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/beverage")
public class BeverageController {
    private final BeverageService beverageService;

    @Autowired
    public BeverageController(BeverageService beverageService) {
        this.beverageService = beverageService;
    }

    @GetMapping("/all")
    public List<Beverage> getAllBeverage() {
        return beverageService.getAllBeverages();
    }

    @GetMapping("/{name}")
    public ResponseEntity<Beverage> getBeverageByName(@PathVariable String name) {
        Beverage beverage = beverageService.findBeverageByName(name).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 음료 이름입니다."));
        if (beverage == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(beverage);
    }

    @PostMapping
    public ResponseEntity<BeverageDTO> addBeverage(@RequestBody BeverageDTO beverageDTO) { // HTTP 메서드의 BODY 로 SON 입력을 받아서 서비스로 넘겨주자
        beverageService.addBeverage(beverageDTO);
        return ResponseEntity.ok().build();
    }


}
