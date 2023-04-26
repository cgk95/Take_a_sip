package com.example.myapi.Controller;

import com.example.myapi.Service.BeverageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BeverageController {
    private final BeverageService beverageService; // 다른 서비스 영역으로 변경될 일이 없기 때문에 final 처리.
    @Autowired
    public BeverageController(BeverageService beverageService) {
        this.beverageService  = beverageService;
    }
}
