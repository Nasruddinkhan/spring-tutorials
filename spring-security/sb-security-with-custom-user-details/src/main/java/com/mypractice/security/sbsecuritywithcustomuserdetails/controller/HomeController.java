package com.mypractice.security.sbsecuritywithcustomuserdetails.controller;


import com.mypractice.security.sbsecuritywithcustomuserdetails.model.Employee;
import com.mypractice.security.sbsecuritywithcustomuserdetails.repo.EmployeeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public final class HomeController {
    private final EmployeeRepository repository;

    public HomeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{name}")
    public String sayHello(@PathVariable String name){
        return "Hello "+name+", <br> you can access this resource only if you have authenticated";
    }

    @GetMapping("/hello")
    public String sayHelloWithoutSecurity(){
        return "Hello use you don't to authentication for accessing this resource";
    }

    @GetMapping
    public List<Employee> findAllEmployee(){
        return repository.findAll();
    }
}
