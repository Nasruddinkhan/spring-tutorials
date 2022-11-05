package com.mypractice.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mypractice.service.BankLoanService;

public class MethodReplacerTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankLoanService service=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		//get Service class object
		service=ctx.getBean("bank",BankLoanService.class);
		System.out.println(service.getClass()+"   "+service.getClass().getSuperclass());
		//invoke methods
		System.out.println(service.calcIntrAmt(100000, 12));
		//close container
		((AbstractApplicationContext) ctx).close();
	}
}
