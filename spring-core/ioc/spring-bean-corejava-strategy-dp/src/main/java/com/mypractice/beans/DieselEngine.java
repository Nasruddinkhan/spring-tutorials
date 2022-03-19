package com.mypractice.beans;

public final class DieselEngine implements Engine {

	public DieselEngine() {
		System.out.println("DieselEngine:0-param constructor");
	}
	
	public void start() {
		System.out.println("Diesel Engine:: started");
		
	}

	public void stop() {
		System.out.println("Diesel Engine:: stopped");
		
	}
	
	

}
