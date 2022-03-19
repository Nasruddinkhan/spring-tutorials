package com.mypractice.beans;

import java.util.Date;

public class MessageGenerator {
	private Date date;
	
	private MessageGenerator(Date dt) {
		super();
		date = dt;
		// TODO Auto-generated constructor stub
		System.out.println("MessageGenerator.MessageGenerator()");
	}
	public String sayHello(String user) {
		return "Hi "+user+ "your calling date"+date;
	}
	
}
