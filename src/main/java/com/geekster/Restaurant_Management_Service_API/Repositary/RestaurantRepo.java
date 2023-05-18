package com.geekster.Restaurant_Management_Service_API.Repositary;

import com.geekster.Restaurant_Management_Service_API.Model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepo extends JpaRepository<Restaurant, Integer> {
}
