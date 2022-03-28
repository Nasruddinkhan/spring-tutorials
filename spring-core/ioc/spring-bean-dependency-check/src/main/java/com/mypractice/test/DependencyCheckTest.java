package com.mypractice.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.mypractice.beans.Person;

public class DependencyCheckTest {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		Person per=null;
		//create IOC container
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("application.xml");
		//get Bean
		per=factory.getBean("per",Person.class);
		System.out.println(per);
		String s = "\"nasruddin";
				//.replace("\"", "");
		System.out.println(s);
	}
}
