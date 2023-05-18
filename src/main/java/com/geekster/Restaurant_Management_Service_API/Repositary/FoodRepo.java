package com.geekster.Restaurant_Management_Service_API.Repositary;

import com.geekster.Restaurant_Management_Service_API.Model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepo extends JpaRepository<Food, Integer> {

}
