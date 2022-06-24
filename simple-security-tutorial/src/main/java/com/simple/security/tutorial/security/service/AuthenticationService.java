package com.simple.security.tutorial.security.service;

import com.simple.security.tutorial.security.jwt.UsernamePasswordAuthenticationRequest;
import org.springframework.security.core.userdetails.UserDetails;

public interface AuthenticationService {
    UserDetails authenticateAndGetUserDetails(UsernamePasswordAuthenticationRequest request);
}
