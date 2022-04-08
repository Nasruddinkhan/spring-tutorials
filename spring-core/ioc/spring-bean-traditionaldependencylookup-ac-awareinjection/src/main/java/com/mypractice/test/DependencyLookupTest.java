package com.mypractice.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mypractice.beans.Viechle;

public class DependencyLookupTest {

	public static void main(String[] args) {
		System.out.println("main(-)");
		ApplicationContext ctx=null;
	    Viechle viechle=null;
		//create IOC container
	    ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("----IOC container of Client App is created----");
		//get Target class object
		viechle=ctx.getBean("viechle",Viechle.class);
		//invoke methods
		viechle.journey("mumbai","pune");
		viechle.entertainment();
		viechle.soundHorn();
		//close container
		((AbstractApplicationContext) ctx).close();
	}

}
