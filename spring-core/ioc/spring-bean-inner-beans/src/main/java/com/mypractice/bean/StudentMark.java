package com.mypractice.bean;

import java.util.Random;

public class StudentMark {
	private String name;

	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return  new Random().nextInt(200);
	}
	public String getName() {
		return name;
	}
	
}
