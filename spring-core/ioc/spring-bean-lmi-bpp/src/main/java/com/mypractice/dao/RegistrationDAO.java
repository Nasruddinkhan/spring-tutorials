package com.mypractice.dao;

import com.mypractice.bo.EmployeeBO;
import com.mypractice.bo.StudentBO;

public interface RegistrationDAO {
	 void insertStudent(StudentBO bo);
	 void insertEmployee(EmployeeBO bo);

}
