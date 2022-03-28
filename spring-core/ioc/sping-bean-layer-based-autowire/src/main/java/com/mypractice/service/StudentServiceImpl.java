package com.mypractice.service;

import com.mypractice.bo.StudentBO;
import com.mypractice.dao.StudentDAO;
import com.mypractice.dto.StudentDTO;

public class StudentServiceImpl implements StudentService {
	private  StudentDAO dao;

	
	public StudentServiceImpl(StudentDAO dao) {
	   System.out.println("StudentServiceImpl::1-param constructor");
		this.dao = dao;
	}




	@Override
	public String evaluateResult(StudentDTO dto) throws Exception {
		System.out.println("StudentServiceImpl.evaluateResult(-)");
		int total=0;
		float avg=0.0f;
		String result=null;
		int  count=0;
		StudentBO bo=null;
		//write b.logic
		total=dto.getM1()+dto.getM2()+dto.getM3();
		avg=total/3.0f;
		 if(dto.getM1()<35 || dto.getM2()<35 || dto.getM3()<35)
			 result="fail";
		 else
			 result="pass";
		 //create BO class obj having persistable data
		 bo=new StudentBO();
		 bo.setSno(dto.getSno());
		 bo.setSname(dto.getSname());
		 bo.setTotal(total);
		bo.setAvg(avg);
		bo.setResult(result);
		//use DAO
		count=dao.insert(bo);
		 if(count==0)
			 return "Student Registration failed :: result is -->"+result;
		 else
			 return dto.getSno()+" Student Registration succeded :: result is -->"+result;
	}

}
