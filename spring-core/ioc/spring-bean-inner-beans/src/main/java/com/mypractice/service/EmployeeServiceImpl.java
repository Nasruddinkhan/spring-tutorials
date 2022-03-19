package com.mypractice.service;

import com.mypractice.bo.EmployeeBOBuilder;
import com.mypractice.dao.EmployeeDao;
import com.mypractice.dto.EmployeeDto;

public class EmployeeServiceImpl implements EmployeeService {
	EmployeeDao empDao;
	public EmployeeServiceImpl(EmployeeDao empDao) {
		super();
		this.empDao = empDao;
	}
	public Double saveSalary(EmployeeDto dto) {
		return empDao.saveSalary( new EmployeeBOBuilder(dto.getEmpID()).setName(dto.getName())
				.setSalary(dto.getCompensition().stream().mapToDouble(m -> m).sum()).build());
	}

}
