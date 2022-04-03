package com.mypractice.controller;

import java.util.ArrayList;
import java.util.List;

import com.mypractice.dto.EmployeeDTO;
import com.mypractice.service.EmployeeService;
import com.mypractice.vo.EmployeeVO;

public class MainController {
	private EmployeeService service;
	
	 public MainController(EmployeeService service) {
			this.service = service;
		}
	 
	 public List<EmployeeVO> getEmpsByDesg(String desg)throws Exception{
        List<EmployeeVO> listVO=new ArrayList();
        List<EmployeeDTO> listDTO=null;
      
		 //use Service
        listDTO=service.findEmpsByDesg(desg);
        //convert listDTO to listVO
     
        listDTO.forEach(dto->{
        	//copy Each DTO class obj to VO class obj
        	EmployeeVO vo=new EmployeeVO();
        	vo.setEmpNo(String.valueOf(dto.getEmpNo()));
        	vo.setEname(dto.getEname());
        	vo.setDesg(dto.getDesg());
        	vo.setSalary(String.valueOf(dto.getSalary()));
        	vo.setSrNo(String.valueOf(dto.getSrNo()));
        	//add VO obj to listVO
        	listVO.add(vo);
        });//for
       return listVO; 
	 }//method
	
}//class
