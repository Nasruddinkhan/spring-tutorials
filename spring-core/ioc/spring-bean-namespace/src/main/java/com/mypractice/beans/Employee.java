package com.mypractice.beans;


public class Employee {
	private int empId;
	private String ename;
	private Department dept;
	private Class clazz;
	
	public Employee() {
		System.out.println("Employee:0-param constructor");
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", ename=" + ename + ", dept=" + dept + ", clazz=" + clazz + "]";
	}
	
	
	
	

}
