package com.sameesh.stockwatcher.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/stat")
    public String stat(){
        LOGGER.warn("it is inside the application :: ");
        return "server is up";
    }

}
