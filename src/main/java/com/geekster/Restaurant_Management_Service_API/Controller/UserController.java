package com.geekster.Restaurant_Management_Service_API.Controller;

import com.geekster.Restaurant_Management_Service_API.Dto.SignInInput;
import com.geekster.Restaurant_Management_Service_API.Dto.SignUpInput;
import com.geekster.Restaurant_Management_Service_API.Model.User;
import com.geekster.Restaurant_Management_Service_API.Service.AuthenticationService;
import com.geekster.Restaurant_Management_Service_API.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("signUp")
    public ResponseEntity<String> SignUp(@RequestBody SignUpInput signUpInput){

        String response;
        HttpStatus status;

        try {
            userService.signUp(signUpInput);
            response = "Sign In successful";
            status = HttpStatus.CREATED;
        }
        catch (Exception e){
            e.printStackTrace();
            response = "Enter Valid Data";
            status = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(response, status);
    }

    @PostMapping("signIn")
    public ResponseEntity<String> SignIn(@RequestBody SignInInput signInInput){
        String response;
        HttpStatus status;

        try {
            userService.signIn(signInInput);
            response = "Sign Up successful";
            status = HttpStatus.CREATED;
        }
        catch (Exception e){
            e.printStackTrace();
            response = "Enter Valid Data";
            status = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(response, status);
    }

    @PutMapping("{userEmail}/{token}")
    public String updateUser(@RequestParam @PathVariable String userEmail, @PathVariable String token, @RequestBody User user) {
        if (authenticationService.authenticateUser(userEmail, token)) {
            return userService.updateUser(user);
        } else {
            return "Signup first!!";
        }
    }


}
