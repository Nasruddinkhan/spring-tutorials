package com.mypractice.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mypractice.controller.MainController;
import com.mypractice.vo.EmployeeVO;

public class NestedApplicaitonContextTest {

	public static void main(String[] args) {
		ApplicationContext pCtx=null,cCtx=null;
		MainController controller=null;
		List<EmployeeVO> listVO=null;
		//create Parent Container
		pCtx=new ClassPathXmlApplicationContext("business-beans.xml");
		//create Child Container
		cCtx=new ClassPathXmlApplicationContext(new String[] {"presentation-beans.xml"},pCtx);
		
				                                                     
		//get Controller
		controller=cCtx.getBean("controller",MainController.class);
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
		
		((AbstractApplicationContext) cCtx).close();
		((AbstractApplicationContext) pCtx).close();
		

	}//main
}//class
