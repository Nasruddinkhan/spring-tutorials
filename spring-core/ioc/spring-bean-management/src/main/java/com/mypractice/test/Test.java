package com.mypractice.test;

import java.util.Date;

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
		Date date = null;
		MessageGenerator messageGenerator = null;
		MessageGenerator messageGenerator1 = null;
		res = new FileSystemResource("src/main/java/com/beans/config/applicationContext.xml");
		factory = new XmlBeanFactory(res);
		date = (Date) factory.getBean("dt");
		System.out.println("Date:::" + date);
		messageGenerator1 = (MessageGenerator) factory.getBean("msg");
		messageGenerator = factory.getBean("msg", MessageGenerator.class);
		System.out.println("message::" + messageGenerator.sayHello("Nasruddin") + " " + messageGenerator1.hashCode());
		System.out.println("message::" + messageGenerator1.sayHello("Nasruddin") + " " + messageGenerator.hashCode());
		System.out.println("end of main(-) method");
	}

}
