package com.bridgelabz.HotelManagement;

import java.util.*;
import java.text.*;

public class Hotel {
	public String hotelName;
	public int weekDayRate;
	public int weekEndRate;
	public int totalCost;
	public int rewardWeekDayRate;
	public int rewardWeekEndRate;
	public int rating;

	public static ArrayList<String> HotelName;
	public static HashMap<String, Integer> HotelNameAndRatingMap;
	public static HashMap<String, Integer> HotelNameAndCostMap;

	// Welcome Message
	public static void Display() {
		System.out.println("Welcome to Hostel Reservation System");
	}

	// Constructor
	public Hotel(String hotelName, int weekDayRate, int weekEndRate, int rewardWeekDayRate, int rewardWeekEndRate,int rating) {
		this.hotelName = hotelName;
		this.weekDayRate = weekDayRate;
		this.weekEndRate = weekEndRate;
		this.rewardWeekDayRate = rewardWeekDayRate;
		this.rewardWeekEndRate = rewardWeekEndRate;
		this.rating = rating;
		HotelNameAndRatingMap = new HashMap<>();
		HotelNameAndCostMap = new HashMap<>();
		HotelName = new ArrayList<>();
	}

	// Method for Calculate Price of Hotel for Regular and Rewards Customer
	public int calculateprice(ArrayList<String> list, String customerType) throws ParseException {
		Iterator<String> it = list.iterator();
		totalCost = 0;
		if (customerType.equals("Regular")) {
			while (it.hasNext()) {
				String day = getDayofWeek(it.next());
				if (day.equals("Sun") || day.equals("Sat")) {
					totalCost += weekEndRate;
				} else {
					totalCost += weekDayRate;
				}
			}
		} else {
			while (it.hasNext()) {
				String day = getDayofWeek(it.next());
				if (day.equals("Sun") || day.equals("Sat")) {
					totalCost += rewardWeekEndRate;
				} else {
					totalCost += rewardWeekEndRate;
				}
			}
		}
		HotelNameAndCostMap.put(hotelName, totalCost);
		HotelNameAndRatingMap.put(hotelName, rating);
		return totalCost;
	}
    //Method for Displaying Hotel Details
	public static void DisplayHotelDetails() {
		for (Map.Entry<String, Integer> entry : HotelNameAndCostMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}

	// Method for determine which hotel is cheapest for us
	public static int minHotelPrice() {
		Integer minPrice = HotelNameAndCostMap.entrySet().stream().min(Map.Entry.comparingByValue()).get().getValue();
		return minPrice;
	}

	// Method for Finding Cheapest Hotel and Highest Rated Hotel Using Map and JavaStream
	public String findCheapestHotel() throws ParseException {
		Integer minPrice = minHotelPrice();
		ArrayList<String> cheapestHotel = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : HotelNameAndCostMap.entrySet()) {
			if (minPrice >= entry.getValue()) {
				minPrice = entry.getValue();
				cheapestHotel.add(entry.getKey());
			}
		}
		String cheapestAndBestRatedHotel = HotelNameAndRatingMap.entrySet().stream().filter(p -> cheapestHotel.contains(p.getKey())).max(Map.Entry.comparingByValue()).get().getKey();
		int highestRating = HotelNameAndRatingMap.entrySet().stream().filter(p -> cheapestHotel.contains(p.getKey())).max(Map.Entry.comparingByValue()).get().getValue();
		System.out.println("Cheapest and Best Rated Hotel is: " + cheapestAndBestRatedHotel + " and Rating of Hotel is : " + highestRating);
		return cheapestAndBestRatedHotel;
	}

	// Method for finding day name of any particular date
	public static String getDayofWeek(String date) throws ParseException {
		SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
		Date dt1 = format1.parse(date);
		DateFormat format2 = new SimpleDateFormat("EE");
		String finalDay = format2.format(dt1);
		return finalDay;
	}
}