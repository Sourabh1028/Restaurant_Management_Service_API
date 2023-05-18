package com.geekster.Restaurant_Management_Service_API.Repositary;

import com.geekster.Restaurant_Management_Service_API.Model.OrderFood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<OrderFood, Integer> {
}
