
/**
 * Nasruddin khan
 * EmpController.java 8 Nov, 2020
 */
package com.mypractice.controller;

import com.mypractice.dto.EmployeeDTO;
import com.mypractice.service.EmployeeService;
import com.mypractice.vo.EmployeeVO;

/**
 * @author MY PC
 *
 */
public class EmpController {
	private EmployeeService service;
	private EmployeeDTO dto;
	public void setService(EmployeeService service) {
		this.service = service;
	}
	public void setDto(EmployeeDTO  dto) {
		this.dto = dto;
	}
	public  int save(EmployeeVO vo)throws Exception {
		dto.setEmpID(vo.getEmpID());
		dto.setName(vo.getName());
		dto.setSalary(vo.getSalary());
		return service.save(dto);
	}
	
}
