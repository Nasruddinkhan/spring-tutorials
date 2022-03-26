/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mypractice.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;
record Employee(String firstName, String lastName, String email) {
}

@Controller
public class EmployeeController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/employees")
    public String getEmployees(Model model,
                               @RegisteredOAuth2AuthorizedClient("users-client-oidc") OAuth2AuthorizedClient authorizedClient) {

        String jwtAccessToken = authorizedClient.getAccessToken().getTokenValue();
        System.out.println("jwtAccessToken =  " + jwtAccessToken);
        String url = "http://localhost:9125/employees/all";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + jwtAccessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<List<Employee>> responseEntity =
                restTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Employee>>() {
                });

        List<Employee> employees = responseEntity.getBody();
        model.addAttribute("employees", employees);
        return "employees-page";

    }
}
