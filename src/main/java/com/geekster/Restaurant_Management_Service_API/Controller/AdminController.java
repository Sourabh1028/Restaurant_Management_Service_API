package com.geekster.Restaurant_Management_Service_API.Controller;

import com.geekster.Restaurant_Management_Service_API.Model.Admin;
import com.geekster.Restaurant_Management_Service_API.Model.OrderStatus;
import com.geekster.Restaurant_Management_Service_API.Model.User;
import com.geekster.Restaurant_Management_Service_API.Service.AdminService;
import com.geekster.Restaurant_Management_Service_API.Service.OrderService;
import com.geekster.Restaurant_Management_Service_API.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;

    @PostMapping("add")
    public String addAdmin(@RequestBody Admin admin){
        return adminService.addAdmin(admin);
    }

    @GetMapping("users/{adminEmail}")
    public List<User> getAllUsers(@RequestParam String adminEmail){
        if(adminService.checkAdmin(adminEmail)){
            return userService.getAllUsers();
        }
        else {
            return null;
        }
    }

    //Update Order Status
    @PutMapping("order/{orderId}/status/{orderStatus}")
    public String updateOrder(@PathVariable Integer orderId, @PathVariable OrderStatus orderStatus){
        return orderService.updateStatus(orderId, orderStatus);
    }
}
