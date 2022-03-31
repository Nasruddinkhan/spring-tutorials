package com.mypractice.test;

import java.awt.FlowLayout;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GUII18nApp {

	public static void main(String[] args) {
		Locale locale=null;
		ResourceBundle bundle=null;
		String label1=null,label2=null,label3=null,label4=null;
		JFrame frame=null;
		JButton btn1=null,btn2=null,btn3=null,btn4=null;
		//create Locale Object
		locale=new Locale("hi","IN");
		//pickup the properties file based on given Locale data
		bundle=ResourceBundle.getBundle("App",locale);
		//get Messages
		label1=bundle.getString("btn.cap1");
		label2=bundle.getString("btn.cap2");
		label3=bundle.getString("btn.cap3");
		label4=bundle.getString("btn.cap4");
		System.out.println(label1+"  "+label2+"  "+label3+"  "+label4);
		//create JFrame and Buttions
		 frame=new JFrame();
		 btn1=new JButton(label1);
		 btn2=new JButton(label2);
		 btn3=new JButton(label3);
		 btn4=new JButton(label4);
		 frame.add(btn1);
		 frame.add(btn2);
		 frame.add(btn3);
		 frame.add(btn4);
		 
		 frame.setVisible(true);
		 frame.setTitle("I18nApp");
		 frame.setLayout(new FlowLayout());
		 frame.pack();
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//main
}//class
