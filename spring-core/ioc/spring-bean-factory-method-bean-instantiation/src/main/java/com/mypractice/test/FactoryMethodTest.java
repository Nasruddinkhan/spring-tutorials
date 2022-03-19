package com.mypractice.test;

import java.util.Calendar;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class FactoryMethodTest {
	public static void main(String[] args) {
		DefaultListableBeanFactory factory = null;
		XmlBeanDefinitionReader reader = null;
		Class c1 = null;
		Calendar cal = null;
		String s2 = null, s4 = null;
		// create IOC container
		factory = new DefaultListableBeanFactory();
		reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("application.xml");
		// get Bean class obj
		c1 = factory.getBean("c1", Class.class);
		System.out.println("c1 obj class: " + c1.getClass() + " c1 obj data::" + c1);
		System.out.println("...........................................");
		cal = factory.getBean("cal", Calendar.class);
		System.out.println("cal obj calss name:" + cal.getClass() + " cal obj data::" + cal);
		System.out.println("..............................................");
		s2 = factory.getBean("s2", String.class);
		System.out.println("s2 obj class :" + s2.getClass() + " s2 obj data::" + s2);
		System.out.println("........................................");
		s4 = factory.getBean("s4", String.class);
		System.out.println("s4 obj class :" + s4.getClass() + " s4 obj data::" + s4);
	}

}
