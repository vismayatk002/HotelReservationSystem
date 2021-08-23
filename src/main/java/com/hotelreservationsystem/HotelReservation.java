package com.hotelreservationsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class HotelReservation {
	
	ArrayList<Hotel> hotelList = new ArrayList<>();
	
	public void addHotel() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the name of Hotel : ");
		String name = sc.nextLine();
		Hotel hotel = new Hotel(name);
		System.out.print("Enter regular customer rate : ");
		int regularCustRate = sc.nextInt();
		hotel.setRegularCustRate(regularCustRate);
		hotelList.add(hotel);
		
	}
    public static void main( String[] args ){
    	
		HotelReservation reservation = new HotelReservation();
		Scanner sc = new Scanner(System.in);
		int continueFlag;
		do {
			System.out.print("\n-------------");
			System.out.print("\n### Menu ###");
			System.out.print("\n-------------");
			System.out.print("\n\n1 : Add Hotel details \n2 : Search Hotel");
			System.out.print("\nChoose your option : ");
			int option = sc.nextInt();
			switch(option) {
				case 1 : 
					reservation.addHotel();
				break;
				default :
					System.out.print("\nInvalid option");
			}
			System.out.print("Do you want to continue? Press 1 : ");
			continueFlag = sc.nextInt();
			
		}while(continueFlag == 1);
    	
		System.out.print("\nThank you for using Hotel Reservation System !!");
		sc.close();
    }
}
