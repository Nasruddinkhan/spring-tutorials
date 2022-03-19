package com.mypractice.test;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mypractice.bean.Company;
import com.mypractice.bean.EmployeeInfo;
import com.mypractice.bean.Resturant;
import com.mypractice.bean.SkillMaster;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		System.out.println(context);
		EmployeeInfo emp = context.getBean("empInfo", EmployeeInfo.class);
		System.out.println(emp);
		Resturant res = context.getBean("resturant", Resturant.class);
		System.out.println(res);
		Company comp = context.getBean("company", Company.class);
		System.out.println(comp);
		SkillMaster skilMst = context.getBean("skilMst", SkillMaster.class);
		System.out.println(skilMst);
		DefaultListableBeanFactory factory = null;
		XmlBeanDefinitionReader reader = null;
		// create IOC container
		List<String> list1 = null;
		List<Date> list2 = null;
		Set<Long> set1 = null;
		Set<Date> set2 = null;
		Map<String, String> map1 = null;
		Map<String, Date> map2 = null;
		Properties props = null;
		factory = new DefaultListableBeanFactory();
		reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("application.xml");
		System.out.println(factory);
		emp = context.getBean("empInfo", EmployeeInfo.class);
		System.out.println(emp);
		list1 = factory.getBean("empList", List.class);
		System.out.println(list1);
		System.out.println("List obj class name::" + list1.getClass());
		System.out.println("..............................................");
		list2 = factory.getBean("dtList", List.class);
		System.out.println(list2);
		System.out.println("List obj class name::" + list2.getClass());
		System.out.println("==================================");
		set1 = factory.getBean("phonesSet", Set.class);
		System.out.println(set1 + "    " + set1.getClass());
		System.out.println("................................................");
		set2 = factory.getBean("dtSet", Set.class);
		System.out.println(set2 + "    " + set2.getClass());
		System.out.println("==================================");
		map1 = factory.getBean("capitalsMap", Map.class);
		System.out.println(map1 + "  " + map1.getClass());
		System.out.println("................................................");
		map2 = factory.getBean("dtMap", Map.class);
		System.out.println(map2 + "   " + map2.getClass());
		System.out.println("========================");
		props = factory.getBean("stateCapitals", Properties.class);
		System.out.println(props + " " + props.getClass());

	}
}
