package com.hotelreservationsystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;

public class HotelReservation {

	ArrayList<Hotel> hotelList = new ArrayList<>();
	LocalDate startDate, endDate;
	
	public void addHotel() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the name of Hotel : ");
		String name = sc.nextLine();
		Hotel hotel = new Hotel(name);
		System.out.print("Enter Hotel rating : ");
		int rating = sc.nextInt();
		hotel.setRating(rating);
		hotelList.add(hotel);
		System.out.print("Enter regular customer weekday rate : ");
		int regCustWeekDayRate = sc.nextInt();
		hotel.setRegCustWeekDayRate(regCustWeekDayRate);
		hotelList.add(hotel);
		System.out.print("Enter regular customer weekend rate : ");
		int regCustWeekEndRate = sc.nextInt();
		hotel.setRegCustWeekEndRate(regCustWeekEndRate);
		hotelList.add(hotel);
		System.out.print("Enter reward customer weekday rate : ");
		int rewCustWeekDayRate = sc.nextInt();
		hotel.setRewCustWeekDayRate(rewCustWeekDayRate);
		hotelList.add(hotel);
		System.out.print("Enter reward customer weekend rate : ");
		int rewCustWeekEndRate = sc.nextInt();
		hotel.setRewCustWeekEndRate(rewCustWeekEndRate);
		hotelList.add(hotel);
	}
	//get list of date between start-dates to end-date
	public ArrayList<LocalDate> getDates() {
		
		ArrayList<LocalDate> dateList = new ArrayList<>();
		
		//find number of days
	    final long noOfDays = ChronoUnit.DAYS.between(startDate, endDate);
	    for(int i = 0; i <= noOfDays; i++){
	    	dateList.add(startDate.plusDays(i));
	    }
	    return dateList;
	}
	
	public void readDate() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter start date : ");
    	String date1 = sc.nextLine();
    	System.out.print("Enter end date : ");
    	String date2 = sc.nextLine();
    	//define date format
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMyyyy"); 
    	//convert given format date into local date
    	startDate = LocalDate.parse(date1, formatter);
        endDate = LocalDate.parse(date2, formatter);
	}
	
	public void findHighestRatedHotel() {
		
		readDate();
		ArrayList<LocalDate> dateList = getDates();
		
		Comparator<Hotel> comparator = Comparator.comparing( Hotel::getRating);
				
		Hotel maxRatedHotel = hotelList
						.stream()
						.max(comparator).get();
		
		System.out.print(maxRatedHotel.getName() + " , Rating : " + maxRatedHotel.getRating() + " , Total Rate : " + maxRatedHotel.getTotalRate(dateList));
		
		}
	
	public void findcheapestHotel() {
		
		readDate();
		ArrayList<LocalDate> dateList = getDates();
		Hotel tempHotel = null;
	    int min = 0; 
	    for(Hotel hotel : hotelList) {
	    	//get total rate for each hotel
	    	int totalRate = hotel.getTotalRate(dateList);
	    	
	    	if(min == 0 || totalRate < min) {
	    		
	    		min = totalRate;
	    		tempHotel = hotel;
	    	}
	    }
	    System.out.print(tempHotel.getName() + " , Rating : " + tempHotel.getRating() + " , Total Rate : " + min);
	}

    public static void main( String[] args ){
    	
		HotelReservation reservation = new HotelReservation();
		Scanner sc = new Scanner(System.in);
		int continueFlag;
		do {
			System.out.print("\n-------------");
			System.out.print("\n### Menu ###");
			System.out.print("\n-------------");
			System.out.print("\n\n1 : Add Hotel details \n2 : Search cheapest Hotel \n3 : Search highest rated Hotel");
			System.out.print("\nChoose your option : ");
			int option = sc.nextInt();
			switch(option) {
				case 1 : 
					reservation.addHotel();
				break;
				case 2 : 
					reservation.findcheapestHotel();
				break;
				case 3 : 
					reservation.findHighestRatedHotel();
				break;
				default :
					System.out.print("\nInvalid option");
			}
			System.out.print("\nDo you want to continue? Press 1 : ");
			continueFlag = sc.nextInt();
			
		}while(continueFlag == 1);
    	
		System.out.print("\nThank you for using Hotel Reservation System !!");
		sc.close();
    }
}
