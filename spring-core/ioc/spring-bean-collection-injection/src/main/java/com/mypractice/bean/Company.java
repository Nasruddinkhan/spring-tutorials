package com.mypractice.bean;

import java.util.Date;
import java.util.List;

public class Company {
	private List<String> empName;
	private List<Date>  joinningDate;
	private List<?>  objList;
	public void setEmpName(List<String> empName) {
		this.empName = empName;
	}
	public void setJoinningDate(List<Date> joinningDate) {
		this.joinningDate = joinningDate;
	}
	public void setObjList(List<?> objList) {
		this.objList = objList;
	}
	@Override
	public String toString() {
		return "Company [empName=" + empName + ", joinningDate=" + joinningDate + ", objList=" + objList + "]";
	}
	
}
