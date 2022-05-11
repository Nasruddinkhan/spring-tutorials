package com.mypractice.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mypractice.beans.MyServletContainer;

public class LMISolutonTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		MyServletContainer container=null,container1=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		//get Taget Bean class obj
		container=ctx.getBean("container",MyServletContainer.class);
		container1=ctx.getBean("container",MyServletContainer.class);
		//invoke methods
		container.processRequest("seven wonders");
		System.out.println(".................................");
		container1.processRequest("nasruddin");
		
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}

}
