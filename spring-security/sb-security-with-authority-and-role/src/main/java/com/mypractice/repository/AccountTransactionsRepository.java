package com.mypractice.repository;

import java.util.List;


import com.mypractice.model.AccountTransactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTransactionsRepository extends JpaRepository<AccountTransactions, Long> {
	
	List<AccountTransactions> findByemployeeIdOrderByTransactionDtDesc(int employeeId);

}
