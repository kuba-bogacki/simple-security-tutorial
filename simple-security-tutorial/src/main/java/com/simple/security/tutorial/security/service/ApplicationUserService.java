package com.simple.security.tutorial.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface ApplicationUserService {
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
    void createNewApplicationUser();
}
