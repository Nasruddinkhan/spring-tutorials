package com.mypractice.controller;

import com.mypractice.model.Accounts;
import com.mypractice.model.Customer;
import com.mypractice.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AccountController {

    @Autowired
    private AccountsRepository accountsRepository;

    @PostMapping("/myAccount")
    public Accounts getAccountDetails(@RequestBody Customer customer) {
        return Optional.ofNullable(accountsRepository.findByEmail(customer.getEmail()))
                .orElseThrow(() -> new RuntimeException("record not found"));

    }

}
