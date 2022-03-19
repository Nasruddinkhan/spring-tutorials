package com.mypractice.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.mypractice.beans.MessageGenerator;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		Resource res = null;
		BeanFactory factory = null;
		MessageGenerator generator = null;
		// Hold spring bean cfg file
		res = new ClassPathResource("applicationContext.xml");
		// create IOC container
		factory = new XmlBeanFactory(res);
		// get Target class obj
		generator = (MessageGenerator) factory.getBean("msg");
		// invoke b.method
		System.out.println("Message:::" + generator.sayHello("Nasruddin khan"));

	}

}
