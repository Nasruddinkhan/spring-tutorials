package com.mypractice.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.mypractice.beans.WishMessageGenerator;

public class SetterInjectionTest {

	public static void main(String[] args) {
		Resource res=null;
		 ApplicationContext ctx=null;
		 WishMessageGenerator generator=null;
		//Hold  Spring Bean cfg file
		res=new FileSystemResource("src/com/mypractice/cfgs/applicationContext.xml");
		//create IOC container
		//ctx=new FileSystemXmlApplicationContext("src/com/mypractice/cfgs/applicationContext.xml");
		ctx=new ClassPathXmlApplicationContext("com/mypractice/cfgs/applicationContext.xml");
		//get Target class obj
		generator=ctx.getBean("wmg",WishMessageGenerator.class);
		//invoke b.method
		System.out.println("Message:::"+generator.sayHello("nasruddin"));
		
		//close container
		((AbstractApplicationContext) ctx).close();
	}

}
