package com.simple.security.tutorial.security.controller;

import com.simple.security.tutorial.security.service.ApplicationUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/application-user")
public class ApplicationUserController {

    private final ApplicationUserService applicationUserService;

    public ApplicationUserController(ApplicationUserService applicationUserService) {
        this.applicationUserService = applicationUserService;
    }

    @PostMapping(value = "/add")
    public void addNewApplicationUser() {
        applicationUserService.createNewApplicationUser();
    }
}
