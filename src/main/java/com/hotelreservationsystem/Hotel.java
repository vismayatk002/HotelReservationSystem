package com.hotelreservationsystem;

public class Hotel {

	String name;
	int regCustWeekDayRate;
	int regCustWeekEndRate;
	
	public Hotel(String name){
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setRegCustWeekDayRate(int regCustWeekDayRate) {
		this.regCustWeekDayRate = regCustWeekDayRate;;
	}
	public int getRegCustWeekDayRate() {
		return regCustWeekDayRate;
	}
	public void setRegCustWeekEndRate(int regCustWeekEndRate) {
		this.regCustWeekEndRate = regCustWeekEndRate;
	}
	public int getRegCustWeekEndRate() {
		return regCustWeekEndRate;
	}
}
