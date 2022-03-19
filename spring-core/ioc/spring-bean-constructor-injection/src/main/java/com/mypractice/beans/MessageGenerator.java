package com.mypractice.beans;

import java.util.Date;

public class MessageGenerator {
	private Date date;
	static {
		System.out.println("MessageGenerator.enclosing_method()");
	}

	public MessageGenerator(Date date2) {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("MessageGenerator.MessageGenerator()"+date2);
		this.date = date;
		
	}

	
	public void setDate1(Date date) {
		System.out.println("MessageGenerator.setDate1()" +date);
		this.date = date;
	}

	public  String sayHello(String user) {
		System.out.println("MessageGenerator.sayHello():::"+date);
		int hour=0; 
		hour=date.getHours();
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
