package com.mypractice.test;

import com.mypractice.beans.CheckVotingElgibity;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class TestBeanLifeCycleTests {
    private static ApplicationContext ctx=null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		((AbstractApplicationContext) ctx).close();
	}

	@Test
	public void testWithInValidAge() {
		CheckVotingElgibity voter=null;
		String actualResult=null,expectedResult=null;
		voter=ctx.getBean("voter",CheckVotingElgibity.class);
		actualResult=voter.elgibilityCheck();
		expectedResult="Mr/Miss/Mrs.Nasruddin u  r  elgible for voting as on ";
		System.out.println("actualResult ["+actualResult+"]");
		System.out.println("actualResult ["+expectedResult+"]");

		Assert.assertTrue("test1",actualResult.contains(expectedResult));
	}
	
	@Test
	public void testWithValidAge() {
		CheckVotingElgibity voter=null;
		String actualResult=null,expectedResult=null;
		voter=ctx.getBean("voter1",CheckVotingElgibity.class);
		actualResult=voter.elgibilityCheck();
		expectedResult="Mr/Miss/Mrs.Nasruddin u  r  elgible for voting as on ";
		assertTrue("test2",actualResult.contains(expectedResult));
	}
	
	@Test(expected=Exception.class)
	public void testWithNegetiveAge() {
		CheckVotingElgibity voter=null;
		String actualResult=null,expectedResult=null;
		voter=ctx.getBean("voter3",CheckVotingElgibity.class);
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



}
