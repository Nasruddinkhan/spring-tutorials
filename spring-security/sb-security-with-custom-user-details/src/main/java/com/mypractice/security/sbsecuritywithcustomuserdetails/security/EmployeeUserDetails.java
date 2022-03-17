package com.mypractice.security.sbsecuritywithcustomuserdetails.security;

import com.mypractice.security.sbsecuritywithcustomuserdetails.model.EmployeeDetails;
import com.mypractice.security.sbsecuritywithcustomuserdetails.repo.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("employeeUserDetails")
@AllArgsConstructor
public class EmployeeUserDetails implements UserDetailsService {
    private final EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return employeeRepository.findByEmail(username).map(EmployeeDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("employee detail not found for this user " + username));
    }
}
