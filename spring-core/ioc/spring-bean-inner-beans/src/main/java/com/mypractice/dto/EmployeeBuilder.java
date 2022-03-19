package com.mypractice.dto;

import java.util.List;

public class EmployeeBuilder {
	private String empID;
	private String name;
	private List<Double> compensition;
	public EmployeeBuilder(String empID) {
		super();
		this.empID = empID;
	}
	public EmployeeBuilder setEmpID(String empID) {
		this.empID = empID;
		return this;
	}
	public EmployeeBuilder setName(String name) {
		this.name = name;
		return this;
	}
	public EmployeeBuilder setCompensition(List<Double> compensition) {
		this.compensition = compensition;
		return this;
	}
	public EmployeeDto build() {
		return new EmployeeDto(empID, name, compensition);
	}

}
