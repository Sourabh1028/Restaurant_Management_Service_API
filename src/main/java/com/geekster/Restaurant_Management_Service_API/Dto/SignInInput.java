package com.geekster.Restaurant_Management_Service_API.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignInInput {

    private String userEmail;
    private String userPassword;
}
