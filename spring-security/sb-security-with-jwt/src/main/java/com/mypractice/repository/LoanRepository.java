package com.mypractice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mypractice.model.Loans;

@Repository
public interface LoanRepository extends JpaRepository<Loans, Long> {
	
	List<Loans> findByEmployeeIdOrderByStartDtDesc(int employeeId);

}
