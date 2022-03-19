package com.mypractice.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.mypractice.beans.Viechle;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
	    Viechle viechle=null;
		//create IOC container
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("application.xml");
		System.out.println("IOC container of Client App is created");
		//get Target class object
		viechle=factory.getBean("bus",Viechle.class);
		//invoke methods
		viechle.journey("MUMBAI","BASTI", factory);
		viechle.entertainment();
		viechle.soundHorn();
	}

}
