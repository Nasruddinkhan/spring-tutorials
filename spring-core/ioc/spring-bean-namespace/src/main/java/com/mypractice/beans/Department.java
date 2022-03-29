package com.mypractice.beans;

import java.util.Date;

public class Department {
	private int dno;
	private String dname;
	private Date startDate;

	public Department(int dno, String dname, Date startDate) {
		System.out.println("Departmet:3-param constructor");
		this.dno = dno;
		this.dname = dname;
		this.startDate = startDate;
	}

	@Override
	public String toString() {
		return "Department [dno=" + dno + ", dname=" + dname + ", startDate=" + startDate + "]";
	}

}
