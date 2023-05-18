package com.geekster.Restaurant_Management_Service_API.Service;

import com.geekster.Restaurant_Management_Service_API.Dto.SignInInput;
import com.geekster.Restaurant_Management_Service_API.Dto.SignUpInput;
import com.geekster.Restaurant_Management_Service_API.Model.AuthenticationToken;
import com.geekster.Restaurant_Management_Service_API.Model.User;
import com.geekster.Restaurant_Management_Service_API.Repositary.AuthenticationRepo;
import com.geekster.Restaurant_Management_Service_API.Repositary.UserRepo;
import jakarta.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    AuthenticationRepo authenticationRepo;

    public void signUp(SignUpInput signUpInput) {

        //check already exist
        boolean CheckUser = userRepo.existsByUserEmail(signUpInput.getUserEmail());
        if(CheckUser){
            throw new IllegalStateException("Sign in instead");
        }

        //encryption
        String encryptedPassword = null;
         try{
            encryptedPassword = encryptPassword(signUpInput.getUserPassword());
        }
         catch (Exception e){
             e.printStackTrace();
         }

         //save user
        User user = new User(signUpInput.getUserFirstName(), signUpInput.getUserLastName(),
                    signUpInput.getUserPhoneNumber(), signUpInput.getUserEmail(), encryptedPassword);

         userRepo.save(user);



    }

    private String encryptPassword(String userPassword) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(userPassword.getBytes());
        byte[] digested =  md5.digest();

        String hash = DatatypeConverter.printHexBinary(digested);
        return hash;
    }

    public void signIn(SignInInput signInInput) {

        //check user is present or not
        User user = userRepo.findFirstByUserEmail(signInInput.getUserEmail());

        //encryption
        String encryptedPassword = null;
        try{
            encryptedPassword = encryptPassword(signInInput.getUserPassword());
        }
        catch (Exception e){
            e.printStackTrace();
        }

        //checking & token creation
        if(encryptedPassword.equals(user.getUserPassword())){
            AuthenticationToken token = new AuthenticationToken(user);
            authenticationRepo.save(token);
        }
        else {
            throw new IllegalStateException();
        }


    }

    @Transactional
    public String updateUser(User user) {
        userRepo.save(user);
        return "User Saved...!!";
    }


    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
