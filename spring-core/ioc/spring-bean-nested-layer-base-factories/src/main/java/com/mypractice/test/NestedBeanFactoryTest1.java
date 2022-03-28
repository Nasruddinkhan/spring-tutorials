package com.mypractice.test;

import com.mypractice.controller.MainController;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class NestedBeanFactoryTest1 {

	public static void main(String[] args) {
		DefaultListableBeanFactory pFactory=null,cFactory=null;
		XmlBeanDefinitionReader reader1=null,reader2=null;
		MainController controller=null;
		//create Parent Container
		pFactory=new DefaultListableBeanFactory();
		reader1=new XmlBeanDefinitionReader(pFactory);
		reader1.loadBeanDefinitions("business-beans.xml");
		
		//create Child Container
		cFactory=new DefaultListableBeanFactory(pFactory);
		reader2=new XmlBeanDefinitionReader(cFactory);
		reader2.loadBeanDefinitions("presentation-beans.xml");
		//get Controller
		controller=cFactory.getBean("controller",MainController.class);
		//invoke methods
		try {
			controller.getEmpsByDesg("FI_ACCOUNT").forEach(System.out::println);
			//display results

		}
		catch(Exception e) {
			System.out.println("Internal Problem::"+e.getMessage());
		}
		

	}//main
}//class
