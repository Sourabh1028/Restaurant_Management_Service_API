package com.geekster.Restaurant_Management_Service_API.Controller;

import com.geekster.Restaurant_Management_Service_API.Model.Restaurant;
import com.geekster.Restaurant_Management_Service_API.Service.AdminService;
import com.geekster.Restaurant_Management_Service_API.Service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("restaurant")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @Autowired
    AdminService adminService;

    @PostMapping("add/{adminEmail}")
    public ResponseEntity<String> addResto(@PathVariable String adminEmail, @RequestBody Restaurant restaurant){
        String response;
        HttpStatus status;

        if(adminService.checkAdmin(adminEmail)){
            restaurantService.addRestaurant(restaurant);
            response = "Restaurant added...!!!";
            status=HttpStatus.ACCEPTED;
        }
        else {
            response = "Only admins can add restaurants...!!!";
            status = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(response, status);
    }

    @PutMapping("update/{adminEmail}")
    public ResponseEntity<String> updateRestaurant(@PathVariable String adminEmail, @RequestBody Restaurant restaurant){
        String response;
        HttpStatus status;

        if (adminService.checkAdmin(adminEmail)) {
            restaurantService.updateRestaurant(restaurant);
            response = "Restaurant updated successfully";
            status = HttpStatus.ACCEPTED;
        }else{
            response = "You're not an admin.... Only admins can add restaurants";
            status = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<String>(response, status);
    }

    @DeleteMapping("{adminEmail}/delete/{id}")
    public String deleteRestaurant(@PathVariable String adminEmail, @PathVariable Integer id){
        if (adminService.checkAdmin(adminEmail)) {
            restaurantService.deleteRestaurant(id);
            return "Restaurant deleted successfully";
        }else{
            return "You're not an admin.... Only admins can add restaurants";
        }
    }
}
