package com.mypractice.beans;

import java.util.Date;

public class ScheduleRemainder {
	private Date remainder;

	public ScheduleRemainder(Date remainder) {
		System.out.println("ScheduleRemainder::1-param constructor");
		this.remainder = remainder;
	}
	
	public String remaindPlan() {
		Date sysDate=null;
		sysDate=new Date();
		if(sysDate.getYear()==remainder.getYear() && sysDate.getMonth()==remainder.getMonth() && sysDate.getDate()==remainder.getDate())
			return  "Poll Results Day.. Get up early in the morning to watch TV";
		else
			return  "No Scheduled  plas on this day.. so just sleep";
		
	}
	
	

}
