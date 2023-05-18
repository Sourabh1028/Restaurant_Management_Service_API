package com.geekster.Restaurant_Management_Service_API.Repositary;

import com.geekster.Restaurant_Management_Service_API.Model.AuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthenticationRepo extends JpaRepository<AuthenticationToken, Integer> {

    AuthenticationToken findByToken(String token);

}
