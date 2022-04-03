package com.mypractice.dao;

import java.util.List;

import com.mypractice.bo.EmployeeBO;

public interface EmployeeDAO {
	
	public  List<EmployeeBO> searchEmpsByDesg(String desg)throws Exception;

}
