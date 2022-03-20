package com.mypractice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Table(name = "accounts")
@Entity
public class Accounts {

	@Column(name = "employee_id")
	private int employeeId;
	@Column(name="account_number")
	@Id
	private long accountNumber;
	@Column(name="account_type")
	private String accountType;
	@Column(name = "branch_address")
	private String branchAddress;
	@Column(name = "create_dt")
	private String createDt;
	

}
