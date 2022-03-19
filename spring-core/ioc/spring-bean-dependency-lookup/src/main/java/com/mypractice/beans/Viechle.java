package com.mypractice.beans;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

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
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		Engine engg=null;
		//create IOC container
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("application.xml");
		System.out.println("IOC container of Viechle class  journey(-,-) is created");
		//perform Dependency lookup to get Dependent class obj
		engg=factory.getBean(beanId,Engine.class);
		//use Dependent class object
		engg.start();
		System.out.println(beanId +" Jounery started and going on.... from"+startPlace+" to "+endPlace);
		engg.stop();
		System.out.println("Jouney Finised at "+endPlace);
	}//method

	public void journey(String startPlace, String endPlace, DefaultListableBeanFactory factory) {
		// TODO Auto-generated method stub
		Engine engg=factory.getBean(beanId,Engine.class);
		//use Dependent class object
		engg.start();
		System.out.println(beanId +" Jounery started and going on.... from"+startPlace+" to "+endPlace);
		engg.stop();
		System.out.println("Jouney Finised at "+endPlace);
	}
}//class
