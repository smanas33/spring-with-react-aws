package com.msahoo.springbootaws.service;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String userName, String password) {
        boolean isValidUserName = userName.equalsIgnoreCase("admin");
        boolean isValidPassword = password.equalsIgnoreCase("dummy");
        return isValidUserName && isValidPassword;
    }
}
