package com.example.SpringSecurity.service;

import com.example.SpringSecurity.model.UserRequestModel;
import org.springframework.http.ResponseEntity;

public abstract class UserService {

    public abstract ResponseEntity<Object> register(UserRequestModel requestModel);
}
