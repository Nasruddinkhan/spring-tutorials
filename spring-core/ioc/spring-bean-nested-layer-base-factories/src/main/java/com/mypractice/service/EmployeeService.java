package com.mypractice.service;

import java.util.List;

import com.mypractice.dto.EmployeeDTO;

public interface EmployeeService {
	public List<EmployeeDTO> findEmpsByDesg(String desg)throws Exception;

}
