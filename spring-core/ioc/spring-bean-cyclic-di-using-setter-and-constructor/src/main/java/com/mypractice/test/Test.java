package com.mypractice.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.mypractice.bean.A;
import com.mypractice.bean.B;

public class Test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 BeanFactory beanFactory =  new XmlBeanFactory( new ClassPathResource("applicationContext.xml"));
		 A a = beanFactory.getBean("a1", A.class);
		 B b = beanFactory.getBean("b1", B.class);
		 System.out.println(a);
		 System.out.println(b);

	}

}
