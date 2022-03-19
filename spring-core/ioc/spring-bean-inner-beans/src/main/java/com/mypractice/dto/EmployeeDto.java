package com.mypractice.dto;

import java.util.List;

public class EmployeeDto {
	private String empID;
	private String name;
	private List<Double> compensition;
	public EmployeeDto(String empID) {
		super();
		this.empID = empID;
	}
	
	public EmployeeDto(String empID, String name, List<Double> compensition) {
		super();
		this.empID = empID;
		this.name = name;
		this.compensition = compensition;
	}

	public String getEmpID() {
		return empID;
	}
	public void setEmpID(String empID) {
		this.empID = empID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Double> getCompensition() {
		return compensition;
	}
	public void setCompensition(List<Double> compensition) {
		this.compensition = compensition;
	}
	
}
