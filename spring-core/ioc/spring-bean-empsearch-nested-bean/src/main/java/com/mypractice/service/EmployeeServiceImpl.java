package com.mypractice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.mypractice.bo.EmployeeBO;
import com.mypractice.dao.EmployeeDAO;
import com.mypractice.dto.EmployeeDTO;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDAO dao;
	

	public EmployeeServiceImpl(EmployeeDAO dao,String status) {
		this.dao = dao;
		System.out.println("EmployeeServiceImpl:: "+status);
	}


	public List<EmployeeDTO> findEmpsByDesg(String desg) throws Exception {
		List<EmployeeBO> listBO=null;
		final List<EmployeeDTO> listDTO=new ArrayList();
	  
		//use DAO
		listBO=dao.searchEmpsByDesg(desg);
		//convert listBO to ListDTO
		
		listBO.forEach(bo->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(bo, dto);
			dto.setSrNo(listDTO.size()+1);
			listDTO.add(dto);
		});
		
		return listDTO;
	}//method
}//class
