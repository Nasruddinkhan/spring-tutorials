package com.mypractice.test;

import com.mypractice.beans.Courier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import com.mypractice.beans.Flipkart;

public class BeanCollabarationWithACTest {

	public static void main(String[] args) {
		Resource res=null;
		ApplicationContext ctx=null;
		Flipkart fpkt=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		//get Bean class obj
		fpkt=ctx.getBean("fpkt",Flipkart.class);

		fpkt.shopping(new String[] {"long kurta","dandiya sticks","rold gold ","kolhapuri"});

		fpkt.setCourier(ctx.getBean("dtdCourier", Courier.class) );
		
		
		//close container
		((AbstractApplicationContext) ctx).close();
	}//main
}//class
