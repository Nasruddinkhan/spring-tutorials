package com.mypractice.controller;


import com.mypractice.model.Employee;
import com.mypractice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
		List<Employee> employees = employeeRepository.findByEmail(user.getName());
		if (employees.size() > 0) {
			return employees.get(0);
		}else {
			return null;
		}
		
	}

}
