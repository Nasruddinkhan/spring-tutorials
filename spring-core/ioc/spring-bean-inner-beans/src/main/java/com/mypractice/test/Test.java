package com.mypractice.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mypractice.bean.Result;
import com.mypractice.main.MainController;
import com.mypractice.vo.EmployeeVOBuilder;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		System.out.println(context);
		Result result = context.getBean("result", Result.class);
		System.out.println(result.result());
		MainController main = context.getBean("main", MainController.class);
		List<Double> compensition = new ArrayList<>();
		compensition.add(8000.0);
		compensition.add(6000.0);
		compensition.add(7000.0);
		compensition.add(9000.0);
		System.out.println(main.operation(
				new EmployeeVOBuilder().setEmpID("101").setName("Nasruddin").setCompensition(compensition).build()));

	}
}
