package com.geekster.Restaurant_Management_Service_API.Controller;

import com.geekster.Restaurant_Management_Service_API.Model.Food;
import com.geekster.Restaurant_Management_Service_API.Model.Restaurant;
import com.geekster.Restaurant_Management_Service_API.Service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("visitor")
public class VisitorController {

    @Autowired
    RestaurantService restaurantService;

    @GetMapping()
    public List<Restaurant> getAllRestaurant(){
        return restaurantService.getAllRestaurant();
    }

    @GetMapping("menu/{restaurantId}")
    public List<Food> getMenu(@RequestParam Integer restaurantId){
        return restaurantService.getMenu(restaurantId);
    }
}
