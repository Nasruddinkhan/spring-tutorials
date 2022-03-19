package com.mypractice.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.mypractice.beans.MessageGenerator;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Resource res = null;
		BeanFactory factory = null;
		MessageGenerator messageGenerator = null;
		MessageGenerator messageGenerator1 = null;
		res = new FileSystemResource("D:\\Projects/spring-tutorials/spring-core/ioc/spring-bean-setter-injection/src/main/resources/applicationContext.xml");
		factory = new XmlBeanFactory(res);
		messageGenerator1 = (MessageGenerator) factory.getBean("msg");
		messageGenerator = factory.getBean("msg", MessageGenerator.class);
		System.out.println("message::" + messageGenerator.sayHello("Nasruddin") + " " + messageGenerator1.hashCode());
		System.out.println("message::" + messageGenerator1.sayHello("Nasruddin") + " " + messageGenerator.hashCode());
		System.out.println("end of main(-) method");
	}

}
