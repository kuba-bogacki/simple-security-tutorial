package com.simple.security.tutorial.security.controller;

import com.simple.security.tutorial.security.jwt.UsernamePasswordAuthenticationRequest;
import com.simple.security.tutorial.security.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping
public class TemplateController {

    private final AuthenticationService authenticationService;

    @Autowired
    public TemplateController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping("/login")
    public String loginUser() {
        return "login";
    }

    @ResponseBody
    @PostMapping(value = "/auth", consumes = {"*/*"})
    public ResponseEntity<?> authenticateUser(@RequestBody UsernamePasswordAuthenticationRequest request) {
        UserDetails userDetails = authenticationService.authenticateAndGetUserDetails(request);
        return ResponseEntity.ok().body(userDetails);
    }

    @GetMapping("/courses")
    public String getCoursePage() {
        return "courses";
    }
}
