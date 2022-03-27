package com.mypractice.beans;

import java.util.Calendar;
import java.util.Date;

public class TravelAgent {
	private TourPlan tp1;
	private Calendar cal;
	
	public TravelAgent(TourPlan tp1) {
		this.tp1=tp1;
		System.out.println("TravelAgen:1-param constructor");
	}
	
	public TravelAgent() {
		System.out.println("TravelAgen:0-param constructor");
	}

	public void setTp1(TourPlan tp1) {
		System.out.println("TravelAgent.setTp1(-)");
		this.tp1 = tp1;
	}
	public  void setCal(Calendar cal) {
		System.out.println("TravelAgent:setCal(-)");
		this.cal=cal;
	}
	
	public  void executePlan() {
		System.out.println("TravelAgent.executePlan()");
		System.out.println(tp1+" places are visited Successfully on date::"+cal);
	}

}
