
/**
 * Nasruddin khan
 * Test.java 8 Nov, 2020
 */
package com.mypractice.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.mypractice.controller.EmpController;
import com.mypractice.vo.EmployeeVO;

/**
 * @author MY PC
 *
 */
public class Test {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BeanFactory factory = null;
		// create IOC container
		factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		// Get Target class obj having Dependent class obj
		System.out.println(factory);
		// get Controller class object
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		EmployeeVO vo = new EmployeeVO();
		vo.setEmpID(Integer.parseInt(br.readLine()));
		vo.setName(br.readLine());
		vo.setSalary(Double.parseDouble(br.readLine()));
		EmpController controller = factory.getBean("controller", EmpController.class);
		int result = controller.save(vo);
		System.out.println(result);
	}

}
