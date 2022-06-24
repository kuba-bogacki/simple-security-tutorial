package com.simple.security.tutorial.security.service.implementation;

import com.simple.security.tutorial.security.jwt.UsernamePasswordAuthenticationRequest;
import com.simple.security.tutorial.security.service.ApplicationUserService;
import com.simple.security.tutorial.security.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImplementation implements AuthenticationService {

    private ApplicationUserService applicationUserService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthenticationServiceImplementation(ApplicationUserService applicationUserService,
                                               PasswordEncoder passwordEncoder) {
        this.applicationUserService = applicationUserService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails authenticateAndGetUserDetails(UsernamePasswordAuthenticationRequest request) {
        UserDetails userDetails = applicationUserService.loadUserByUsername(request.getUsername());
        if (userDetails.getUsername().equals(request.getUsername())
                && passwordEncoder.matches(request.getPassword(), userDetails.getPassword())) {
            System.out.println("Authenticate user");
        } else {
            System.out.println("Incorrect username or password");
            throw new BadCredentialsException("Incorrect username or password");
        }
        return userDetails;
    }
}
