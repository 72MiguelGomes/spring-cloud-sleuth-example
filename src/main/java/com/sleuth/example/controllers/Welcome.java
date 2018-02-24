package com.sleuth.example.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;

@RestController
public class Welcome {

    private static final Logger LOGGER = LoggerFactory.getLogger(Welcome.class);

    private final RestTemplate restTemplate;

    @Autowired
    public Welcome(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping("/welcome")
    public String welcome(@RequestParam(required = false) String name) {

        LOGGER.info("create welcome message");


        if ("next".equalsIgnoreCase(name)) {
            restTemplate.getForObject("http://localhost:8282/hey", String.class);
        }

        return MessageFormat.format("Welcome {0}", name != null ? name : "man!");
    }

}
