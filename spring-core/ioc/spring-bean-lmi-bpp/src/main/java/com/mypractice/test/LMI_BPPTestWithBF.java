package com.mypractice.test;


import com.mypractice.service.RegistrationService;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class LMI_BPPTestWithBF {

	public static void main(String[] args) {
		RegistrationService service=null;
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		BeanPostProcessor bpp=null;
		//create IOC container
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("applicationContext.xml");
		//register BeanPostPostProcessor with Container
		bpp=factory.getBean("dbpp",BeanPostProcessor.class);
		factory.addBeanPostProcessor(bpp);
		//get Service class object
		service=factory.getBean("regService",RegistrationService.class);
		System.out.println(service.getClass());
		service.registerEmployee("pqr","xcvxcv","programmer");
		System.out.println("......................");
		service.registerEmployee("abc","xcvxcv","programmer");
		System.out.println("==========================");
		service.registerStudent("mnfo","xcvxcv","java");
		System.out.println("......................");
		service.registerStudent("xcvxcvxcv","cxvxcvcxv","oracle");
		
	}

}
