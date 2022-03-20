package com.mypractice.config;

import com.mypractice.model.SecurityEmployee;
import com.mypractice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class BankUserDetails implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return employeeRepository.findByEmail(username)
                .map(SecurityEmployee::new).orElseThrow(() -> new UsernameNotFoundException("User details not found for the user : " + username));

    }

}
