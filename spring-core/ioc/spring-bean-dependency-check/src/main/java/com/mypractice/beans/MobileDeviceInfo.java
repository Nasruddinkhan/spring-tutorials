package com.mypractice.beans;

public class MobileDeviceInfo {
	private long number;
	private String imeiNo;
	private  String make;
	
	public MobileDeviceInfo() {
		System.out.println("MobileDeviceInfo::0-param constructor");
	}
	
	public void setNumber(long number) {
		this.number = number;
	}
	public void setImeiNo(String imeiNo) {
		this.imeiNo = imeiNo;
	}
	public void setMake(String make) {
		this.make = make;
	}
	
	@Override
	public String toString() {
		return "MobileDeviceInfo [number=" + number + ", imeiNo=" + imeiNo + ", make=" + make + "]";
	}
	
	

}
