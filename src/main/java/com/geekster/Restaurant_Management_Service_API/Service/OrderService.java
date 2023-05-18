package com.geekster.Restaurant_Management_Service_API.Service;

import com.geekster.Restaurant_Management_Service_API.Model.*;
import com.geekster.Restaurant_Management_Service_API.Repositary.FoodRepo;
import com.geekster.Restaurant_Management_Service_API.Repositary.OrderRepo;
import com.geekster.Restaurant_Management_Service_API.Repositary.RestaurantRepo;
import com.geekster.Restaurant_Management_Service_API.Repositary.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    RestaurantRepo restaurantRepo;

    @Autowired
    FoodRepo foodRepo;

    @Autowired
    UserRepo userRepo;


    public String orderFood(OrderFood orderFood) {
        Restaurant restaurant = restaurantRepo.findById(orderFood.getRestaurant().getRestaurantId()).get();
        Food food = foodRepo.findById(orderFood.getFood().getFoodId()).get();
        User user = userRepo.findById(orderFood.getUser().getUserId()).get();

        orderFood.setRestaurant(restaurant);
        orderFood.setUser(user);
        orderFood.setFood(food);

        orderRepo.save(orderFood);
        return "Your order is placed!!";
    }

    public String updateStatus(Integer orderId, OrderStatus orderStatus) {
        OrderFood order = orderRepo.findById(orderId).get();
        order.setStatus(orderStatus);
        return "You're order is Updated !!!";
    }
}
