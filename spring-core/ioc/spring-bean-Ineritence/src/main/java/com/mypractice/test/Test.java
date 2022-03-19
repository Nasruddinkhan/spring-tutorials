package com.mypractice.test;

import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mypractice.bean.Car;
import com.mypractice.controller.MainController;
import com.mypractice.vo.StudentVO;

public class Test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		System.out.println(context);
		System.out.println(context.getBean("car1", Car.class));
		System.out.println(context.getBean("car2", Car.class));
		System.out.println(context.getBean("car3", Car.class));
		// System.out.println(context.getBean("baseCar", Car.class));
		System.out.println("RealtimeDITest:: start of main()");
		Scanner sc = null;
		String sno = null, sname = null, m1 = null, m2 = null, m3 = null;
		StudentVO vo = null;
		MainController controller = null;
		String result = null;
		// read inputs
		sc = new Scanner(System.in);
		System.out.println("Enter Sno::");
		sno = sc.next();
		System.out.println("Enter name::");
		sname = sc.next();
		System.out.println("Enter marks1::");
		m1 = sc.next();
		System.out.println("Enter marks2::");
		m2 = sc.next();
		System.out.println("Enter marks3::");
		m3 = sc.next();
		// create StudentVO class object
		vo = new StudentVO();
		vo.setSno(sno);
		vo.setM1(m1);
		vo.setM2(m2);
		vo.setM3(m3);
		vo.setSname(sname);
		controller = context.getBean("controller", MainController.class);
		try {
			// invoke method
			result = controller.generateResult(vo);
			System.out.println("Result is :::" + result);
		} // try
		catch (Exception e) {
			if (((SQLException) e).getErrorCode() == 1) {
				System.out.println("Inter problem -->User Already registered");
			} else if (((SQLException) e).getErrorCode() == 12899) {
				System.out.println("Internal Problem---> Values are larger than colum size");
			} else {
				e.printStackTrace();
				System.out.println("Internal problem");
			}
		} // catch

	}

}
