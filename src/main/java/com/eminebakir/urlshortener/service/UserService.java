package com.eminebakir.urlshortener.service;

import com.eminebakir.urlshortener.entity.User;
import com.eminebakir.urlshortener.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService{
    User save(UserRegistrationDto registrationDto);
}