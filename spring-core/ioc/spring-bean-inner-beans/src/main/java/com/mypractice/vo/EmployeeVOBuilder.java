package com.mypractice.vo;

import java.util.List;

public class EmployeeVOBuilder {
	private String empID;
	private String name;
	private List<Double> compensition;
	public EmployeeVOBuilder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeVOBuilder setEmpID(String empID) {
		this.empID = empID;
		return this;
	}
	public EmployeeVOBuilder setName(String name) {
		this.name = name;
		return this;

	}
	public EmployeeVOBuilder setCompensition(List<Double> compensition) {
		this.compensition = compensition;
		return this;
	}
	
	public EmployeeVO build() {
		return new EmployeeVO(empID, name, compensition);
	}
	
	public  class EmployeeVO {
		private String empID;
		private String name;
		private List<Double> compensition;
		
		public EmployeeVO(String empID, String name, List<Double> compensition) {
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

}
