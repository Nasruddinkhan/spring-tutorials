package com.mypractice.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.mypractice.beans.Flipkart;

public class BeanCollabarationTest {

	public static void main(String[] args) {
		Resource res=null;
		BeanFactory factory=null;
		Flipkart fpkt=null;
		//Hold Spring bean cfg file
		res=new ClassPathResource("applicationContext.xml");
		//create IOC container
		factory=new XmlBeanFactory(res);
		//get Taget class obj injecting with Depedent class obj
		fpkt=factory.getBean("fpkt",Flipkart.class);
		//invoke b.method
		System.out.println(fpkt.shopping(new String[] {"long kurta","dandiya sticks","rold gold ","kolhapuri"}));

		
	}//main
}//class
