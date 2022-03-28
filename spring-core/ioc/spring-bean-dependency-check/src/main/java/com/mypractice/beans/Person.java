package com.mypractice.beans;

public class Person {
	private int pid;
	private String pname;
	private String addrs;
	private MobileDeviceInfo deviceInfo;
	private  int age;
	
	public Person() {
		System.out.println("Person:0-param constructor");
	}
	
	public void setPid(int pid) {
		this.pid = pid;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}
	public void setDeviceInfo(MobileDeviceInfo deviceInfo) {
		this.deviceInfo = deviceInfo;
	}
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", addrs=" + addrs + ", deviceInfo=" + deviceInfo + "]";
	}
	
	

}
