package com.example.myapi.Products.Service;

import com.example.myapi.Products.Controller.BeverageDTO;
import com.example.myapi.Products.Controller.OptionDTO;
import com.example.myapi.Products.Repository.BeverageRepository;
import com.example.myapi.Entity.Beverage;
import com.example.myapi.Entity.Option;
import com.example.myapi.Entity.Enums.Size;
import com.example.myapi.Entity.Enums.Temperature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BeverageService {
    private final BeverageRepository beverageRepository;

    @Autowired
    public BeverageService(BeverageRepository beverageRepository) {
        this.beverageRepository = beverageRepository;
    }

    @Transactional
    public void addBeverage(BeverageDTO beverageDTO) { // FIXME :: 반복문을 따로 객체로 분리해서 mapper 만들기
        Beverage newBeverage = new Beverage(beverageDTO.getName(), beverageDTO.getDescription());

        for (OptionDTO curr : beverageDTO.getOptions()) {
            Option newOption = new Option(Size.valueOf(curr.getSize()), Temperature.valueOf(curr.getTemperature()), curr.getPrice());
            newBeverage.addOption(newOption);
        }
        beverageRepository.save(newBeverage);
    }


    @Transactional
    public void addOptionToBeverage(String name, Option option) {
        Beverage beverage = beverageRepository.findBeverageByName(name);
        beverage.addOption(option);
        beverageRepository.save(beverage);
    }

    // 조회
    public List<Beverage> getAllBeverages() {
        return beverageRepository.findAll();
    }

    public Optional<Beverage> findBeverageByName(String name) {
        return Optional.ofNullable(this.beverageRepository.findBeverageByName(name));
    }
}
