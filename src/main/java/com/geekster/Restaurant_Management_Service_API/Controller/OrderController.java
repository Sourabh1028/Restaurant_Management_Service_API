package com.geekster.Restaurant_Management_Service_API.Controller;

import com.geekster.Restaurant_Management_Service_API.Model.OrderFood;
import com.geekster.Restaurant_Management_Service_API.Service.AuthenticationService;
import com.geekster.Restaurant_Management_Service_API.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("{userEmail}/{token}")
    public String orderFood(@RequestParam String userEmail, @RequestParam String token, @RequestBody OrderFood order){
        if(authenticationService.authenticateUser(userEmail,token)){
            return orderService.orderFood(order);
        }else{
            return "Enter a valid Data";
        }
    }
}
