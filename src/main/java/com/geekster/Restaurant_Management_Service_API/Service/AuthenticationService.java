package com.geekster.Restaurant_Management_Service_API.Service;

import com.geekster.Restaurant_Management_Service_API.Model.AuthenticationToken;
import com.geekster.Restaurant_Management_Service_API.Repositary.AuthenticationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    AuthenticationRepo authRepo;

    public boolean authenticateUser(String userEmail, String token) {
        AuthenticationToken token1 = authRepo.findByToken(token);
        String expectedEmail = token1.getUser().getUserEmail();
        return  expectedEmail.equals(userEmail);
    }

    public void saveToken(AuthenticationToken token) {
        authRepo.save(token);
    }
}
