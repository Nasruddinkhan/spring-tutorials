package com.mypractice.controller;

import java.util.List;

import com.mypractice.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mypractice.model.Loans;
import com.mypractice.repository.LoanRepository;

@RestController
public class LoansController {
	
	@Autowired
	private LoanRepository loanRepository;
	
	@PostMapping("/myLoans")
	public List<Loans> getLoanDetails(@RequestBody Customer customer) {
		List<Loans> loans = loanRepository.findByEmailOrderByStartDtDesc(customer.getEmail());
		if (loans != null ) {
			return loans;
		}else {
			return null;
		}
	}

}
