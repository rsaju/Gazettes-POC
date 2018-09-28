package com.gazette.poc.API.controllers;

import com.gazette.poc.API.entities.UserDTO;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;

@Controller
public class RegistrationController {

    @Inject
    RestTemplate restTemplate;

    @GetMapping("/register")
    public String getSignUpForm() {
        return "signupform";
    }

    @PostMapping("/register")
    public String registerUser(@Valid UserDTO user) throws RuntimeException {
        Gson gson = new Gson();
        String json = gson.toJson(user);
        if (restTemplate.postForEntity("http://db-service"+ "/add_user", json, String.class).getStatusCode().is2xxSuccessful()) {
            return "homepage";
        }
        else return "error";
    }
}
