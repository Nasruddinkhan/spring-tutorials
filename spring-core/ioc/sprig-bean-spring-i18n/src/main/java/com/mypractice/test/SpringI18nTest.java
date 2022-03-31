package com.mypractice.test;

import java.awt.FlowLayout;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringI18nTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		Locale locale=null;
		String cap1=null,cap2=null,cap3=null,cap4=null,cap11,cap111=null;
		JFrame frame=null;
		JButton btn1=null,btn2=null,btn3=null,btn4=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
       //create Locale obj
		locale=new Locale("hi","IN");
		//get MEssages
		cap1=ctx.getMessage("btn.cap1",new Object[] {"student"}, "cap1", locale);
		cap11=ctx.getMessage("btn.cap1",new Object[] {"student"},"cap11",new Locale("de","DE"));
		cap111=ctx.getMessage("btn.cap2",new Object[] {"student"},"cap111",new Locale("hi","IN"));
		
		System.out.println(cap1+"   "+cap11+"  "+cap111);
		
		cap2=ctx.getMessage("btn.cap2",new Object[] {}, "cap2", locale);
		cap3=ctx.getMessage("btn.cap3",new Object[] {}, "cap3", locale);
		cap4=ctx.getMessage("btn.cap4",new Object[] {}, "cap4", locale);
		
		//create Frame
		//create JFrame and Buttions
		 frame=new JFrame();
		 btn1=new JButton(cap1);
		 btn2=new JButton(cap2);
		 btn3=new JButton(cap3);
		 btn4=new JButton(cap4);
		 frame.add(btn1);
		 frame.add(btn2);
		 frame.add(btn3);
		 frame.add(btn4);
		 
		 frame.setVisible(true);
		 frame.setTitle("I18nApp");
		 frame.setLayout(new FlowLayout());
		 frame.pack();
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

}
