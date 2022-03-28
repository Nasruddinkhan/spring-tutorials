package com.mypractice.test;

import com.mypractice.controller.MainController;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class NestedBeanFactoryTest {

	public static void main(String[] args) {
		BeanFactory pFactory=null,cFactory=null;
		MainController controller=null;
		//create Parent Container
		pFactory=new XmlBeanFactory(new ClassPathResource("business-beans.xml"));
		//create Child Container
		cFactory=new XmlBeanFactory(new ClassPathResource("presentation-beans.xml"),pFactory);
				                                                     
		//get Controller
		controller=cFactory.getBean("controller",MainController.class);
		//invoke methods
		try {
			controller.getEmpsByDesg("ST_CLERK").forEach(System.out::println);
			//display results

		}
		catch(Exception e) {
			System.out.println("Internal Problem::"+e.getMessage());
		}
		

	}//main
}//class
