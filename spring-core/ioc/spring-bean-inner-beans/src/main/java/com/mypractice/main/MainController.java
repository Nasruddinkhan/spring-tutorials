package com.mypractice.main;

import com.mypractice.dto.EmployeeBuilder;
import com.mypractice.service.EmployeeService;
import com.mypractice.vo.EmployeeVOBuilder.EmployeeVO;

public final class MainController {
	EmployeeService service;

	public MainController(EmployeeService service) {
		super();
		this.service = service;
	}

	public Double operation(EmployeeVO vo) {
		return service.saveSalary(
				new EmployeeBuilder(vo.getEmpID()).setName(vo.getName()).setCompensition(vo.getCompensition()).build());
	}
}
