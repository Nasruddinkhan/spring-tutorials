package com.mypractice.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.mypractice.beans.InvoiceSystem;

public class BeanCollabarationTest {

	public static void main(String[] args) {
		Resource res=null;
		BeanFactory factory=null;
		InvoiceSystem invoice=null;
		//Hold Spring bean cfg file
		res=new ClassPathResource("applicationContext.xml");
		//create IOC container
		factory=new XmlBeanFactory(res);
		//get Taget class obj injecting with Depedent class obj
		Class<InvoiceSystem> c=InvoiceSystem.class;
		invoice= factory.getBean("invoiceSystem", c);
		//invoke b.method
		System.out.println(invoice.invoice(new String[] {"itme1","itme2","itme3 ","itme4"}));

	}//main
}//class
