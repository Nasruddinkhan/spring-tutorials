package com.mypractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mypractice.model.Accounts;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {
	
	Accounts findByEmployeeId(int employeeId);

}
