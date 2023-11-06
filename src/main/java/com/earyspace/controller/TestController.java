package com.earyspace.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {

    @RequestMapping("/test")
    public String test(){
        log.info("This inof log");
        return "Test Page";
    }
}
