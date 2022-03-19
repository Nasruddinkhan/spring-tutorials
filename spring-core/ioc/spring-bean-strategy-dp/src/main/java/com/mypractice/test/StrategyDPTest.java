package com.mypractice.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.mypractice.beans.Viechle;


public class StrategyDPTest{

	public static void main(String[] args) {
		BeanFactory factory=null;
		Viechle viechle=null;
		//create IOC container
		factory=new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		//Get Target class obj having Dependent class obj
		viechle=factory.getBean("viechle",Viechle.class);
		viechle.journey("UP","MUMBAI");
		System.out.println(".....................");
		viechle=factory.getBean("viechle",Viechle.class);
		viechle.journey("MUMBAI","UP");
	}

}
