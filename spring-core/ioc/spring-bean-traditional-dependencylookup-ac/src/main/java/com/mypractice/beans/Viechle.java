package com.mypractice.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Viechle {
	private String beanId;
	
	public Viechle(String beanId) {
		this.beanId=beanId;
		System.out.println("Viechle:0-param cosntructor");
	}
	
	public    void entertainment() {
		System.out.println("This viechle is equipped with Xplod  DVD player");
	}
	public void   soundHorn() {
		System.out.println("This viechle is equipped with skoda horn");
	}
	
	public  void journey(String startPlace,String endPlace) {
		System.out.println("Viechle.journey(-,-)");
	     ApplicationContext ctx=null;
		Engine engg=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		//perform Dependency lookup to get Dependent class obj
		engg=ctx.getBean(beanId,Engine.class);
		//use Dependent class object
		engg.start();
		System.out.println("Jounery started and going on.... from"+startPlace+" to "+endPlace);
		engg.stop();
		System.out.println("Jouney Finised at"+endPlace);
	}//method
}//class
