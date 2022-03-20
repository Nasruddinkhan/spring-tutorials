package com.mypractice.config;

import com.mypractice.model.Authority;
import com.mypractice.model.Employee;
import com.mypractice.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class BankUsernamePwdAuthenticationProvider implements AuthenticationProvider {


    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) {
        String username = authentication.getName();
        String pwd = authentication.getCredentials().toString();
        Optional<Employee> employee = employeeRepository.findByEmail(username);
        if (employee.isPresent()) {
            if (passwordEncoder.matches(pwd, employee.get().getPassword())) {
                return new UsernamePasswordAuthenticationToken(username, pwd, getGrantedAuthorities(employee.get().getAuthorities()));
            }
            throw new BadCredentialsException("Invalid password!");
        }
        throw new BadCredentialsException("No user registered with this details!");
    }

    private List<GrantedAuthority> getGrantedAuthorities(Set<Authority> authorities) {
        return authorities.stream().map(m-> new SimpleGrantedAuthority(m.getName())).collect(Collectors.toList());
    }

    @Override
    public boolean supports(Class<?> authenticationType) {
        return authenticationType.equals(UsernamePasswordAuthenticationToken.class);
    }
}
