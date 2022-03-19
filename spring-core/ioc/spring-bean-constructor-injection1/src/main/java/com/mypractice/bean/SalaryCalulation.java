package com.mypractice.bean;

import java.beans.ConstructorProperties;

public class SalaryCalulation {
	private double basic;
	private double hra;
	private double otherAllowance;

	@ConstructorProperties(value={"ba","hr","othAllow"})
	public SalaryCalulation(double basic, double hra, double otherAllowance) {
		super();
		this.basic = basic;
		this.hra = hra;
		this.otherAllowance = otherAllowance;
	}

	@Override
	public String toString() {
		return "SalaryCalulation [basic=" + basic + ", hra=" + hra + ", otherAllowance=" + otherAllowance + "]";
	}

}
