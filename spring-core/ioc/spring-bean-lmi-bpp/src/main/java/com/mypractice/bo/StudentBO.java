package com.mypractice.bo;

import lombok.Data;

@Data
public class StudentBO extends BaseBO {
  private String course;
  
  public StudentBO() {
	  System.out.println("StudentBO::0-param constructor");
  }

@Override
public String toString() {
	return "StudentBO [course=" + course + ", getName()=" + getName() + ", getAddrs()=" + getAddrs() + ", getDoj()="
			+ getDoj() + "]";
}
  
  
  
}
