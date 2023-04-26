package com.example.myapi.Repository;

import com.example.myapi.Repository.Entity.Beverage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeverageRepository extends JpaRepository<Beverage, Long>{
    Beverage findBeverageByName(String name);

}
