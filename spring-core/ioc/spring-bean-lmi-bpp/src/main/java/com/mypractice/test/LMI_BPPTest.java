package com.mypractice.test;


import com.mypractice.service.RegistrationService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LMI_BPPTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		RegistrationService service=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		//get Service class object
		service=ctx.getBean("regService",RegistrationService.class);
		System.out.println(service.getClass());
		service.registerEmployee("xcvxcv","xcvxcvxcv","programmer");
		System.out.println("......................");
		service.registerEmployee("xcvxcvxcv","xcvxcvxcv","programmer");
		System.out.println("==========================");
		service.registerStudent("xcvxcv","xcvxcvxcv","java");
		System.out.println("......................");
		service.registerStudent("xcvxcv","xcvxcvcxv","oracle");
		
		//close container
		((AbstractApplicationContext) ctx).close();
		

	}

}
