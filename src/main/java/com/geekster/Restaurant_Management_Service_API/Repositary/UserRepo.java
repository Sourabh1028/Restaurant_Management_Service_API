package com.geekster.Restaurant_Management_Service_API.Repositary;

import com.geekster.Restaurant_Management_Service_API.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

    boolean existsByUserEmail(String userEmail);

    User findFirstByUserEmail(String userEmail);

}
