package com.mypractice.bean;

public class B {
	private A a;
  //constuctor injectiom
	/*public B(A a) {
		super();
		this.a = a;
	}
*/
	//setter injection
	
	public B(A a) {
		this.a = a;
		System.out.println("B:1-param constructor");
	}
	@Override
	public String toString() {
		return "B [a=" + a + "]";
	}


//	public void setA(A a) {
//		this.a = a;
//	}

}
