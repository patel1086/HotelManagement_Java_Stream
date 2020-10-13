package com.bridgelabz.HotelManagement;

import java.util.*;

import java.text.*;

public class Hotel {
	public String hotelname;
	public int weekdayrate;
	public int weekendrate;
	static int costofLakewood;
	static int costofBridgewood;
	static int costofRidgewood;
	public int rating;
	static int ratingofLakewood=3;
	static int ratingofBridgewood=4;
	static int ratingofRidgewood=5;
	
    //Welcome Message
	public static void Display() {
		System.out.println("Welcome to Hostel Reservation System");
	}
	//Constructor
	public Hotel(String hotelname, int weekdayrate, int weekendrate, int rating) {
		this.hotelname = hotelname;
		this.weekdayrate = weekdayrate;
		this.weekendrate = weekendrate;
		this.rating = rating;
	}
	public Hotel() {
		
	}
    //Method for Calculate Price of Hotel for Regular and Rewards Customer
	public static String calculateprice(ArrayList<String> list, String customer,String typeOfMood) throws ParseException {
		Iterator<String> it = list.iterator();
		costofLakewood=0;
		costofBridgewood=0;
		costofRidgewood=0;
		if (customer.equals("Regular")) {
			while (it.hasNext()) {
				String day = getDayofWeek(it.next());
				if (day.equals("Sun") || day.equals("Sat")) {
					costofLakewood += 90;
					costofBridgewood += 60;
					costofRidgewood += 150;
				} else {
					costofLakewood += 110;
					costofBridgewood += 150;
					costofRidgewood += 220;
				}
			}
		} 
		else {
			while (it.hasNext()) {
				String day = getDayofWeek(it.next());
				if (day.equals("Sun") || day.equals("Sat")) {
					costofLakewood += 80;
					costofBridgewood += 50;
					costofRidgewood += 40;
				} else {
					costofLakewood += 80;
					costofBridgewood += 110;
					costofRidgewood += 100;
				}
			}
		}
		if(typeOfMood.equals("goodRatingHotel")) {
			int result=max(ratingofLakewood,ratingofBridgewood,ratingofRidgewood);
			if (result == ratingofLakewood) {
				System.out.println("Lakewood Hotel, Rating: " + ratingofLakewood + " Total cost for staying of "
						+ list.size() + " days is: " + costofLakewood);
				return "Lakewood";
			} else if (result == ratingofBridgewood) {
				System.out.println("Bridgewood Hotel, Rating: " + ratingofBridgewood + " Total cost for staying of "
						+ list.size() + " days is: " +costofBridgewood );
				return "Bridgewood";
			} else {
				System.out.println("Ridgewood Hotel, Rating: " + ratingofRidgewood + " Total cost for staying of "
						+ list.size() + " days is: " + costofRidgewood);
				return "Ridgewood";
			}
		}
		else if(typeOfMood.equals("cheapHotel")){
			int result = min(costofLakewood, costofBridgewood, costofRidgewood);
			if (result == costofLakewood) {
				System.out.println("Lakewood Hotel, Rating: " + ratingofLakewood + " Total cost for staying of "
						+ list.size() + " days is: " + result);
				return "Lakewood";
			} else if (result == costofBridgewood) {
				System.out.println("Bridgewood Hotel, Rating: " + ratingofBridgewood + " Total cost for staying of "
						+ list.size() + " days is: " + result);
				return "Bridgewood";
			} else {
				System.out.println("Ridgewood Hotel, Rating: " + ratingofRidgewood + " Total cost for staying of "
						+ list.size() + " days is: " + result);
				return "Ridgewood";
			}
		}
		else {
			return null;
		}
	}
	//Method to get Highest Rating
	public static int max(int rate_L, int rate_B,int rate_R) {
		if(rate_L > rate_B && rate_L > rate_R)
			return rate_L;
		else if(rate_B > rate_L && rate_B > rate_R)
			return rate_B;
		else if(rate_R > rate_L && rate_R > rate_B)
			return rate_R;
		else if(rate_B == rate_L && rate_B > rate_R)
			return rate_B;
		else if(rate_L == rate_R && rate_L > rate_B)
			return rate_L;
		else
			return rate_R;
	}
	//Method for determine which hotel is cheapest for us
	public static int min(int price_L, int price_B, int price_R) {
		if (price_L < price_B && price_L < price_R)
			return price_L;
		else if (price_B < price_L && price_B < price_R)
			return price_B;
		else if (price_R < price_L && price_R < price_B)
			return price_R;
		else if (price_L == price_B && price_B < price_R)
			return price_L;
		else if (price_L == price_R && price_L < price_B)
			return price_L;
		else
			return price_R;
	}
	//Method for finding day of any particular date
	public static String getDayofWeek(String date) throws ParseException {
		SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
		Date dt1 = format1.parse(date);
		DateFormat format2 = new SimpleDateFormat("EE");
		String finalDay = format2.format(dt1);
		return finalDay;
	}
}