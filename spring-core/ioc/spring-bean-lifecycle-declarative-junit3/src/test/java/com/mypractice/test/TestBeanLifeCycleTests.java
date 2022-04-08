package com.mypractice.test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.mypractice.beans.CheckVotingElgibity;

import junit.framework.TestCase;

public class TestBeanLifeCycleTests extends TestCase {
	static {
		System.out.println("BeanLifeCycleTests::static block");
	}
    private  ApplicationContext ctx=null;
	
	public  void setUp() {
		System.out.println("BeanLifeCycleTests.setUp()");
		ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	
	public  void tearDown() throws Exception {
		System.out.println("BeanLifeCycleTests:tearDown()");
		((AbstractApplicationContext) ctx).close();
	}

	public void testWithInValidAge() {
		System.out.println("BeanLifeCycleTests.testWithInValidAge()");
		CheckVotingElgibity voter=null;
		String actualResult=null,expectedResult=null;
		voter=ctx.getBean("voter",CheckVotingElgibity.class);
		actualResult=voter.elgibilityCheck();
		expectedResult="Mr/Miss. Nasruddin u  r not elgible for voting as on ";
		System.out.println(expectedResult+"   "+actualResult);
		assertTrue("test1",actualResult.contains(expectedResult));
	}
	
	
	public void testWithValidAge() {
		System.out.println("BeanLifeCycleTests.testWithValidAge()");
		CheckVotingElgibity voter=null;
		String actualResult=null,expectedResult=null;
		voter=ctx.getBean("voter1",CheckVotingElgibity.class);
		actualResult=voter.elgibilityCheck();
		expectedResult="Mr/Miss/Mrs.Nasruddin u  r  elgible for voting as on ";
		assertTrue("test2",actualResult.contains(expectedResult));
	}
	
	/*@Test(expected=Exception.class)
	public void testWithNegetiveAge() {
		CheckVotingElgibity voter=null;
		String actualResult=null,expectedResult=null;
		voter=ctx.getBean("voter2",CheckVotingElgibity.class);
		actualResult=voter.elgibilityCheck();
		fail("Exception is expected here ,but not raised");
	}
	
	@Test(expected=Exception.class)
	public void testWithNoName() {
		CheckVotingElgibity voter=null;
		String actualResult=null,expectedResult=null;
		voter=ctx.getBean("voter3",CheckVotingElgibity.class);
		actualResult=voter.elgibilityCheck();
		fail("Exception is expected here ,but not raised");
	}
*/


}
