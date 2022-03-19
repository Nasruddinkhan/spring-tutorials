package com.mypractice.bean;

import java.util.Date;

public class Employee {
	
	private Integer empId;
	private String name;
	private Date doj;
	
	public Employee(Date doj) {
		super();
		this.doj = doj;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", doj=" + doj + "]";
	}
	
}
