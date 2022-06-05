package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.MyServletContainer;

public class LMISolutonTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		MyServletContainer container=null,container1=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Taget Bean class obj
		container=ctx.getBean("container",MyServletContainer.class);
		//invoke methods
		container.processRequest("seven wonders");
		System.out.println(".................................");
		container.processRequest("ameerpet");
		
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}

}
