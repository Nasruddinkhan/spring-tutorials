package com.mypractice.beans;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Viechle implements ApplicationContextAware {
	private String beanId;
	ApplicationContext ctx=null;
	
	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		System.out.println("Viechle:setApplicationContext(-)");
		this.ctx=ctx;
	}
	
	public Viechle(String beanId) {
		this.beanId=beanId;
		System.out.println("Viechle:0-param cosntructor");
	}
	
	//b.methods
	public    void entertainment() {
		System.out.println("This viechle is equipped with Xplod  DVD player");
	}
	public void   soundHorn() {
		System.out.println("This viechle is equipped with skoda horn");
	}
	
	public  void journey(String startPlace,String endPlace) {
		System.out.println("Viechle.journey(-,-)");
		Engine engg=null;
		//perform Dependency lookup to get Dependent class obj
		engg=ctx.getBean(beanId,Engine.class);
		//use Dependent class object
		engg.start();
		System.out.println("Jounery started and going on.... from"+startPlace+" to "+endPlace);
		engg.stop();
		System.out.println("Jouney Finised at"+endPlace);
	}//method

	
}//class
