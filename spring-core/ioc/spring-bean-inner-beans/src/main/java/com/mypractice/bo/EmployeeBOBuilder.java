package com.mypractice.bo;

public class EmployeeBOBuilder {
	private String empID;
	private String name;
	private Double salary;
	
	public EmployeeBOBuilder(String empID) {
		super();
		this.empID = empID;
	}
	public EmployeeBOBuilder(String empID, String name, Double salary) {
		super();
		this.empID = empID;
		this.name = name;
		this.salary = salary;
	}
	public EmployeeBOBuilder setEmpID(String empID) {
		this.empID = empID;
		return this;
	}
	public EmployeeBOBuilder setName(String name) {
		this.name = name;
		return this;
	}
	public EmployeeBOBuilder setSalary(double salary) {
		this.salary = salary;
		return this;
	}
	public EmployeeBO build() {
		return new EmployeeBO(empID, name, salary);
	}

}
