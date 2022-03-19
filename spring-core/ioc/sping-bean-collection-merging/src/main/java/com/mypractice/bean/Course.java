package com.mypractice.bean;

import java.util.List;

public class Course {
	private List<String> courses;

	public void setCourses(List<String> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Course [courses=" + courses + "]";
	}
}
