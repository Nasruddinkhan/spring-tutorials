package com.mypractice.beans;

public final class Viechle {
	private Engine engine;
	
	
	public Viechle() {
		System.out.println("Viechle:0-param constructor");
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	public void journey(String startPlace,String destPlace) {
		engine.start();
		System.out.println("at "+startPlace);
		System.out.println("Viechle is moving...........");
		engine.stop();
		System.out.println("At "+destPlace);
	}//method
	
}//class
