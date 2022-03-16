package com.mypractice.spring.data.ldap.sbdataldap.controller;

import com.mypractice.spring.data.ldap.sbdataldap.model.User;
import com.mypractice.spring.data.ldap.sbdataldap.repo.UserRepository;
import org.springframework.ldap.support.LdapUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<User> findAllUser(){
        return repository.findAll();
    }

    @PostMapping
    public User saveUser(@RequestBody User user){
        user.setId(LdapUtils.newLdapName(user.getIds()));
        return repository.save(user);
    }

    @GetMapping("/{username}/name")
    public User getUser(@PathVariable String username){
        return repository.findByUsername(username);
    }
}
