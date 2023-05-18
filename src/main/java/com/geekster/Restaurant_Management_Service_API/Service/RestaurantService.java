package com.geekster.Restaurant_Management_Service_API.Service;

import com.geekster.Restaurant_Management_Service_API.Model.Food;
import com.geekster.Restaurant_Management_Service_API.Model.Restaurant;
import com.geekster.Restaurant_Management_Service_API.Repositary.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepo restaurantRepo;

    public void addRestaurant(Restaurant restaurant) {
        restaurantRepo.save(restaurant);
    }

    public void updateRestaurant(Restaurant restaurant) {
        restaurantRepo.save(restaurant);
    }

    public void deleteRestaurant(Integer id) {
        restaurantRepo.deleteById(id);
    }

    public List<Restaurant> getAllRestaurant() {
        return restaurantRepo.findAll();
    }

    public List<Food> getMenu(Integer restaurantId) {
        Restaurant restaurant = restaurantRepo.findById(restaurantId).get();
        return restaurant.getFood();
    }
}
