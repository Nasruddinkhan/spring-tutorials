package com.mypractice.controller;


import com.mypractice.model.Employee;
import com.mypractice.model.SecurityEmployee;
import com.mypractice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class LoginController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@RequestMapping("/user")
	public Employee getUserDetailsAfterLogin(Principal user) {
		return employeeRepository.findByEmail(user.getName())
				.orElseThrow(() -> new UsernameNotFoundException("User details not found for the user : " + user.getName()));
	}

}
