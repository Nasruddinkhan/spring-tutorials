package com.mypractice.beans;

public final class PetrolEngine implements Engine {

	public PetrolEngine() {
		System.out.println("PetrolEngine:0-param constructor");
	}
	
	public void start() {
		System.out.println("Petrol Engine:: started");
		
	}

	public void stop() {
		System.out.println("Petrol Engine:: stopped");
		
	}
	
	

}
