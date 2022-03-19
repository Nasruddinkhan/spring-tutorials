package com.mypractice.beans;

public final class CNGEngine implements Engine {
	
	public CNGEngine() {
		System.out.println("CNGEngine:0-param constructor");
	}
	

	public void start() {
		System.out.println("CNGEngine:: started");
		
	}

	public void stop() {
		System.out.println(" CNG Engine:: stopped");
		
	}
	
	

}
