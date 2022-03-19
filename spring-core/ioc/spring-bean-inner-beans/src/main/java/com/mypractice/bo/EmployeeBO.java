package com.mypractice.bo;

public final class EmployeeBO {
	private String empID;
	private String name;
	private Double salary;
	public EmployeeBO(String empID, String name, Double salary) {
		super();
		this.empID = empID;
		this.name = name;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "EmployeeBO [empID=" + empID + ", name=" + name + ", salary=" + salary + "]";
	}
	public String getEmpID() {
		return empID;
	}
	public String getName() {
		return name;
	}
	public Double getSalary() {
		return salary;
	}
	
}
