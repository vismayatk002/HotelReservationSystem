package com.hotelreservationsystem;

public class Hotel {

	String name;
	int regularCustRate;
	
	public Hotel(String name){
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setRegularCustRate(int regularCustRate) {
		this.regularCustRate = regularCustRate;
	}
	public int getRegularCustRate() {
		return regularCustRate;
	}
}
