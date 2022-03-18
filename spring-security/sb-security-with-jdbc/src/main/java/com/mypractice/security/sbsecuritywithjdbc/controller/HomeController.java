package com.mypractice.security.sbsecuritywithjdbc.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class HomeController {

    @GetMapping("/{name}")
    public String sayHello(@PathVariable String name){

        return "Hello "+name+", <br> you can access this resource only if you have authenticated";
    }

    @GetMapping("/hello")
    public String sayHelloWithoutSecurity(){
        return "Hello use you don't to authentication for accessing this resource";
    }
}
