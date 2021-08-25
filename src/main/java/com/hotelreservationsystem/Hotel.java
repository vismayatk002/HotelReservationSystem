package com.hotelreservationsystem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

public class Hotel {

	String name;
	int regCustWeekDayRate;
	int regCustWeekEndRate;
	int rating;
	int rewCustWeekDayRate;
	int rewCustWeekEndRate;
	
	public Hotel(String name){
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getRating() {
		return rating;
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
	public void setRewCustWeekDayRate(int rewCustWeekDayRate) {
		this.rewCustWeekDayRate = rewCustWeekDayRate;;
	}
	public int getRewCustWeekDayRate() {
		return rewCustWeekDayRate;
	}
	public void setRewCustWeekEndRate(int rewCustWeekEndRate) {
		this.rewCustWeekEndRate = rewCustWeekEndRate;
	}
	public int getRewCustWeekEndRate() {
		return rewCustWeekEndRate;
	}
	
	public int getCustWeekDayRate(String customerType) {
		
		if(customerType.compareTo("Regular") == 0) {
			return getRegCustWeekDayRate();
		}
		else {
			return getRewCustWeekDayRate();
		}
	}
	
	public int getCustWeekEndRate(String customerType) {
		
		if(customerType.compareTo("Regular") == 0) {
			return getRegCustWeekEndRate();
		}
		else {
			return getRewCustWeekEndRate();
		}
	}

	public int getTotalRate(ArrayList<LocalDate> dateList, String customerType) {
		
		int totalRate = 0;
    	
    	for(LocalDate date : dateList) {
    		//get day 
		    DayOfWeek day = date.getDayOfWeek();
		    if(day.compareTo(DayOfWeek.SATURDAY) == 0 || day.compareTo(DayOfWeek.SUNDAY) == 0) {
		    
			    totalRate +=  getCustWeekEndRate(customerType);
		    }
		    else {
		    	totalRate +=  getCustWeekDayRate(customerType);
		    }
    	}
    	return totalRate;
	}	
}
