package com.geekster.Restaurant_Management_Service_API.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpInput {

    @NotNull
    private String userFirstName;

    @NotNull
    private String userLastName;

    @Email
    private String userEmail;

    @NotNull
    private String userPassword;

    @NotNull
    private String userPhoneNumber;
}
