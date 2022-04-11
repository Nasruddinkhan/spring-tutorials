package com.mypractice.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyServletContainer {
	private String beanId;
	public MyServletContainer(String beanId) {
		System.out.println("MyServletContainer::1-param constructor");
		this.beanId = beanId;
	}


	
	
	
	public  void processRequest(String data) {
		ApplicationContext ctx=null;
		RequestHandler handler=null;
		//perform TDL
		ctx=new ClassPathXmlApplicationContext("src/main/resources/applicationContext.xml");
		handler=ctx.getBean(beanId,RequestHandler.class);
		//use RequestHadler
		System.out.println("request came for processing");
		handler.handleRequest(data);
		System.out.println("Request is processed");
	}
}
