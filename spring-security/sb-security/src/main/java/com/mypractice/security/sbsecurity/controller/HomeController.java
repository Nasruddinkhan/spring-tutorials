package com.mypractice.security.sbsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public final class HomeController {

    @GetMapping(params = "name")
    public String sayUser(@RequestParam final String name){
        return "Hello "+ name + ",<br> welcome to our basic spring security application";
    }
}
