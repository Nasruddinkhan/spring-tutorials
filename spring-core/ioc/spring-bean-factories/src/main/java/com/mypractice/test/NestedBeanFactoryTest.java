package com.mypractice.test;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

import com.mypractice.controller.MainController;
import com.mypractice.vo.EmployeeVO;

public class NestedBeanFactoryTest {

	public static void main(String[] args) {
		BeanFactory pFactory=null,cFactory=null;
		MainController controller=null;
		List<EmployeeVO> listVO=null;
		PropertySourcesPlaceholderConfigurer configurer=null;
		//create Parent Container
		pFactory=new XmlBeanFactory(new ClassPathResource("business-beans.xml"));
		configurer=pFactory.getBean(PropertySourcesPlaceholderConfigurer.class); 
		configurer.postProcessBeanFactory((ConfigurableListableBeanFactory) pFactory);;
		//create Child Container
		cFactory=new XmlBeanFactory(new ClassPathResource("presentation-beans.xml"),pFactory);
				                                                     
		//get Controller
		controller=cFactory.getBean("controller",MainController.class);
		//invoke methods
		try {
			listVO=controller.getEmpsByDesg("ST_CLERK");
			//display results
			for(EmployeeVO vo:listVO) {
				System.out.println(vo);
			}
		}
		catch(Exception e) {
			System.out.println("Internal Problem::"+e.getMessage());
		}
		

	}//main
}//class
