package com.mypractice.dao;

import com.mypractice.bo.EmployeeBO;
import com.mypractice.bo.StudentBO;

public class RegistrationDAOImpl implements RegistrationDAO {
	
	public RegistrationDAOImpl() {
		System.out.println("RegistrationDAOImpl::0-param constructor");
	}

	@Override
	public void insertStudent(StudentBO bo) {
	    System.out.println("Registrering Student with Data .."+bo);
	}

	@Override
	public void insertEmployee(EmployeeBO bo) {
		System.out.println("Registrering Employee with Data .."+bo);
	}

}
