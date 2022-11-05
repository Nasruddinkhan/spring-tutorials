package com.mypractice.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mypractice.beans.TestBean;

public class BeanLifeCycleTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		TestBean bean=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("1...");
		//get bean
		bean=ctx.getBean("tb",TestBean.class);
		System.out.println("2.....");
		System.out.println("result::"+bean.generateWishMessage("raja"));
		
		//close container
		((AbstractApplicationContext) ctx).close();
		
		

	}

}
