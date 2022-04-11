package com.mypractice.beans;

public class MyServletContainer {
	private RequestHandler handler;

	public MyServletContainer(RequestHandler handler) {
		System.out.println("MyServletContainer::1-param constructor");
		this.handler = handler;
	}
	
	public  void processRequest(String data) {
		//use RequestHadler
		System.out.println("request came for processing");
		handler.handleRequest(data);
		System.out.println("Request is processed");
	}
}
