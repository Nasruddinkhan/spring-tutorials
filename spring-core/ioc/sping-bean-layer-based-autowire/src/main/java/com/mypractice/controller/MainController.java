package com.mypractice.controller;

import com.mypractice.dto.StudentDTO;
import com.mypractice.service.StudentService;
import com.mypractice.vo.StudentVO;

public final class MainController {
	private StudentService service;
	
	
	public MainController(StudentService service) {
		System.out.println("MainController::1-param constructor");
		this.service=service;
	}


	
	public  String generateResult(StudentVO vo)throws Exception{
		System.out.println("MainController.generateResult(-)");
		 String result=null;
		 StudentDTO dto=null;
		//Convert StudentVO class obj to StudentDTO class obj
		 dto=new StudentDTO();
		 dto.setSno(Integer.parseInt(vo.getSno()));
		 dto.setSname(vo.getSname());
		 dto.setM1(Integer.parseInt(vo.getM1()));
		 dto.setM2(Integer.parseInt(vo.getM2()));
		 dto.setM3(Integer.parseInt(vo.getM3()));
		 //use Service
		 result=service.evaluateResult(dto);
		 return result;
	}
	

}
