package com.mypractice.bean;

import java.util.Date;

public class WishMessageGenerator {
	private  Date date;
	static {
		System.out.println("WishMessageGenerator.static block");
	}
	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator::0-param constructor");
	}

	public void setDate(Date date) {
		System.out.println("WishMessageGenerator.setDate(-)");
		this.date = date;
	}
	
	public  String sayHello(String user) {
		System.out.println("WishMessageGenerator.sayHello(-)");
		int hour=0; 
		//get current hour of the day
		hour=date.getHours();
		//generate wish Message
		if(hour<12)
			return "GM::"+user;
		else if(hour<=16)
			return "GA::"+user;
		else if(hour<=20)
			return "GE::"+user;
		else
			return "GN::"+user;
	}
	

}
