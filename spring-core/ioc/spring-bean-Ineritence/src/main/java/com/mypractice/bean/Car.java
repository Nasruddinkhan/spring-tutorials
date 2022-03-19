package com.mypractice.bean;

public  class Car {
	private String regNo;
	private String ownerName;
	private String make;
	private String modelName;
	private String carType;
	private String color;
	private int engineCC;
	private int seatsCount;
	private int price;
	private String fuelType;
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setEngineCC(int engineCC) {
		this.engineCC = engineCC;
	}
	public void setSeatsCount(int seatsCount) {
		this.seatsCount = seatsCount;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	@Override
	public String toString() {
		return "Car [regNo=" + regNo + ", ownerName=" + ownerName + ", make=" + make + ", modelName=" + modelName
				+ ", carType=" + carType + ", color=" + color + ", engineCC=" + engineCC + ", seatsCount=" + seatsCount
				+ ", price=" + price + ", fuelType=" + fuelType + "]";
	}
	
	
}
