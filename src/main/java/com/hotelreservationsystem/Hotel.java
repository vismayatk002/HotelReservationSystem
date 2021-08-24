package com.hotelreservationsystem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

public class Hotel {

	String name;
	int regCustWeekDayRate;
	int regCustWeekEndRate;
	int rating;
	
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
	
	public int getTotalRate(ArrayList<LocalDate> dateList) {
		
		int totalRate = 0;
    	
    	for(LocalDate date : dateList) {
    		//get day 
	    	DayOfWeek day = date.getDayOfWeek();
	    	if(day.compareTo(DayOfWeek.SATURDAY) == 0 || day.compareTo(DayOfWeek.SUNDAY) == 0) {
	    
		    	totalRate +=  getRegCustWeekEndRate();
	    	}
	    	else {
	    		totalRate +=  getRegCustWeekDayRate();
	    	}
    	}
    	return totalRate;
	}
}
