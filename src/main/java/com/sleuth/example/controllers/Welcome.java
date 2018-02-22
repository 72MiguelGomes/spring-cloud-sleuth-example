package com.sleuth.example.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;

@RestController
public class Welcome {

    private static final Logger LOGGER = LoggerFactory.getLogger(Welcome.class);

    @RequestMapping("/welcome")
    public String welcome(@RequestParam(required = false) String name) {

        LOGGER.info("create welcome message");

        return MessageFormat.format("Welcome {0}", name != null ? name : "man!");
    }

}
