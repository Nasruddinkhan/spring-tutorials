package com.mypractice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mypractice.model.Employee;
import com.mypractice.model.Loans;
import com.mypractice.repository.LoanRepository;

@RestController
public class LoansController {
	
	@Autowired
	private LoanRepository loanRepository;
	
	@PostMapping("/myLoans")
	public List<Loans> getLoanDetails(@RequestBody Employee employee) {
		List<Loans> loans = loanRepository.findByEmployeeIdOrderByStartDtDesc(employee.getId());
		if (loans != null ) {
			return loans;
		}else {
			return null;
		}
	}

}
