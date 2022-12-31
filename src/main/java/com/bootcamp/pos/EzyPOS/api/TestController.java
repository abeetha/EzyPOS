package com.bootcamp.pos.EzyPOS.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {

    @GetMapping("/access")
    public String access(){
        return "Hello Spring Test Controller";
    }
}
