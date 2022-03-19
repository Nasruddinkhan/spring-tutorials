package com.mypractice.spring.security.security;

import com.mypractice.spring.security.model.EmployeeDetails;
import com.mypractice.spring.security.repo.EmployeeRepository;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Category("customAuthProvider")
public class CustomAuthProvider implements AuthenticationProvider {
    private final EmployeeRepository employeeRepository;
    @Autowired
    public CustomAuthProvider(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        var username = authentication.getName();
        var password = authentication.getCredentials().toString();
        var authorities = employeeRepository.findByEmail(username)
                .map(EmployeeDetails::new).map(EmployeeDetails::getAuthorities)
                .orElseThrow(() -> new UsernameNotFoundException("employee detail not found for this user " + authentication.getName()));
        return new UsernamePasswordAuthenticationToken(username, password, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
