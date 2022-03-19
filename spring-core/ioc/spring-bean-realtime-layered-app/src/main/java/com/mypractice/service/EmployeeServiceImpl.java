
/**
 * Nasruddin khan
 * EmployeeServiceImpl.java 8 Nov, 2020
 */
package com.mypractice.service;

import com.mypractice.bo.EmployeeBO;
import com.mypractice.dao.EmployeeDAO;
import com.mypractice.dto.EmployeeDTO;

/**
 * @author MY PC
 *
 */
public class EmployeeServiceImpl implements EmployeeService {
	private  EmployeeDAO  dao;
	private EmployeeBO bo;
	

	

	public void setBo(EmployeeBO bo) {
		this.bo = bo;
	}


	public void setDao(EmployeeDAO dao) {
		this.dao = dao;
	}


	@Override
	public int save(EmployeeDTO dto) throws Exception {
		// TODO Auto-generated method stub
		bo.setEmpID(dto.getEmpID());
		bo.setName(dto.getName());
		bo.setSalary(dto.getSalary());
		
		return dao.save(bo);
	}
	
}
