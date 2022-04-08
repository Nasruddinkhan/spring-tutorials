package com.mypractice.beans;

import java.util.Date;

public class FirstFlight implements Courier {
	public FirstFlight() {
		System.out.println("FirstFlight:0-param constructor");
	}

	public void deliver(int oid) {
		System.out.println(oid+" order is delivered to customer on "+new Date()+"  by FirstFlight");
	

	}

}
