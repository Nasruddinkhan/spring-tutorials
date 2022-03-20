package com.mypractice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mypractice.model.AccountTransactions;
import com.mypractice.model.Employee;
import com.mypractice.repository.AccountTransactionsRepository;

@RestController
public class BalanceController {

	@Autowired
	private AccountTransactionsRepository accountTransactionsRepository;
	
	@PostMapping("/myBalance")
	public List<AccountTransactions> getBalanceDetails(@RequestBody Employee employee) {
		List<AccountTransactions> accountTransactions = accountTransactionsRepository.
				findByemployeeIdOrderByTransactionDtDesc(employee.getId());
		if (accountTransactions != null ) {
			return accountTransactions;
		}else {
			return null;
		}
	}
}
