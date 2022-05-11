package com.mypractice.beans;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyServletContainer implements ApplicationContextAware {
	private String beanId;
	private ApplicationContext ctx;
	public MyServletContainer(String beanId) {
		System.out.println("MyServletContainer::1-param constructor");
		this.beanId = beanId;
	}


	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		this.ctx=ctx;
	}

	
	
	
	public  void processRequest(String data) {
		RequestHandler handler=null;
		//perform TDL
		handler=ctx.getBean(beanId,RequestHandler.class);
		//use RequestHadler
		System.out.println("request came for processing");
		handler.handleRequest(data);
		System.out.println("Request is processed");
	}





}
