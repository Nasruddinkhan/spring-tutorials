package com.mypractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mypractice.model.Accounts;
import com.mypractice.model.Employee;
import com.mypractice.repository.AccountsRepository;

@RestController
public class AccountController {
	
	@Autowired
	private AccountsRepository accountsRepository;
	
	@PostMapping("/myAccount")
	public Accounts getAccountDetails(@RequestBody Employee employee) {
		Accounts accounts = accountsRepository.findByEmployeeId(employee.getId());
		if (accounts != null ) {
			return accounts;
		}else {
			return null;
		}
	}

}
