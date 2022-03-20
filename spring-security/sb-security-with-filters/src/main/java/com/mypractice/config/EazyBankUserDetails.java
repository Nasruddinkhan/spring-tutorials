package com.mypractice.config;

import java.util.List;

import com.mypractice.model.SecurityEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mypractice.model.Employee;
import com.mypractice.repository.EmployeeRepository;

@Service
public class EazyBankUserDetails implements UserDetailsService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<Employee> employee = employeeRepository.findByEmail(username);
		if (employee.isEmpty()) {
			throw new UsernameNotFoundException("User details not found for the user : " + username);
		}
		return new SecurityEmployee(employee.get(0));
	}

}
