package com.mypractice.resource.server.controller;

import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @ConstructorBinding
    public record Employee(String firstName, String lastName, String email) {

    }
    @GetMapping("/all")
    public List<Employee> findAllEmployees() {
        return List.of(new Employee("nasruddin", "khan", "nasruddinkhan44@gmail.com"));
    }

}
