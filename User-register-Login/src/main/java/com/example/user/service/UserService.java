package com.example.user.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.user.model.User;
import com.example.user.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
  User save(UserRegistrationDto registrationDto);
}
 