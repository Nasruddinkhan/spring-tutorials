package com.mypractice.bo;

import lombok.Data;

@Data
public class EmployeeBO extends BaseBO {
	private String desg;
	
	public EmployeeBO() {
		  System.out.println("EmployeeBO::0-param constructor");
	  }

	@Override
	public String toString() {
		return "EmployeeBO [desg=" + desg + ", getName()=" + getName() + ", getAddrs()=" + getAddrs() + ", getDoj()="
				+ getDoj() + "]";
	}

	
	

}
