package com.mypractice.bean;

public class A {
	private B b;

	// constructor injection
	/*
	 * public A(B b) { super(); this.b = b; }
	 */
	public A() {
		// this.b=b;
		System.out.println("A:0-param cosntructor");
	}

	@Override
	public String toString() {
		return "A [b=" + b + "]";
	}
	public void setB(B b) { 
		this.b = b;
	}

}
