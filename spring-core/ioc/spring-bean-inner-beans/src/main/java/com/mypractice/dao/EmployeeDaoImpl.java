package com.mypractice.dao;

import com.mypractice.bo.EmployeeBO;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public Double saveSalary(EmployeeBO build) {
		// TODO Auto-generated method stub
		System.out.println("EmployeeDaoImpl.saveSalary()"+build);
		return  build.getSalary();
	}

}
