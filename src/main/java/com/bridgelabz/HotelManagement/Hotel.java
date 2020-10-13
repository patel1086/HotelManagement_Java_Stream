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
	static int ratingofLakewood = 3;
	static int ratingofBridgewood = 4;
	static int ratingofRidgewood = 5;

	// Welcome Message
	public static void Display() {
		System.out.println("Welcome to Hostel Reservation System");
	}

	// Constructor
	public Hotel(String hotelname, int weekdayrate, int weekendrate, int rating) {
		this.hotelname = hotelname;
		this.weekdayrate = weekdayrate;
		this.weekendrate = weekendrate;
		this.rating = rating;
	}

	public Hotel() {

	}

	// Method for Calculate Price of Hotel for Regular and Rewards Customer
	public static String calculateprice(ArrayList<String> list, String customer, String typeOfMood) throws ParseException {
		Iterator<String> it = list.iterator();
		costofLakewood = 0;
		costofBridgewood = 0;
		costofRidgewood = 0;
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
		} else {
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
		if (typeOfMood.equals("goodRatingHotel")) {
			int result = max(ratingofLakewood, ratingofBridgewood, ratingofRidgewood);
			if (result == ratingofLakewood) {
				System.out.println("Lakewood Hotel, Rating: " + ratingofLakewood + " Total cost for staying of "
						+ list.size() + " days is: " + costofLakewood);
				return "Lakewood";
			} else if (result == ratingofBridgewood) {
				System.out.println("Bridgewood Hotel, Rating: " + ratingofBridgewood + " Total cost for staying of "
						+ list.size() + " days is: " + costofBridgewood);
				return "Bridgewood";
			} else {
				System.out.println("Ridgewood Hotel, Rating: " + ratingofRidgewood + " Total cost for staying of "
						+ list.size() + " days is: " + costofRidgewood);
				return "Ridgewood";
			}
		} else if (typeOfMood.equals("cheapHotel")) {
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
		} else {
			return null;
		}
	}

	// Method to get Highest Rating
	public static int max(int rate_L, int rate_B, int rate_R) {
		List<Integer> list = Arrays.asList(rate_L, rate_B, rate_R);
		Integer maxRating = list.stream().max(Integer::compare).get();
		return maxRating;
	}

	// Method for determine which hotel is cheapest for us
	public static int min(int price_L, int price_B, int price_R) {
		List<Integer> list = Arrays.asList(price_L, price_B, price_R);
		Integer minPrice = list.stream().min(Integer::compare).get();
		return minPrice;
	}

	// Method for Finding Cheapest Hotel and Highest Rated Hotel Using Map and Java Stream
	public static String cheapestHotelByStream(ArrayList<String> list, String customer, String typeOfMood) throws ParseException {
		String hotelName = calculateprice(list, customer, typeOfMood);
		HashMap<String, Integer> HotelNameAndCostMap = new HashMap<>();
		HashMap<String, Integer> HotelNameAndRatingMap = new HashMap<>();

		if (typeOfMood.equals("goodRatingHotel")) {
			HotelNameAndRatingMap.put("Lakewood", 3);
			HotelNameAndRatingMap.put("Bridgewood", 4);
			HotelNameAndRatingMap.put("Ridgewood", 5);
			String bestRatingHotel = HotelNameAndRatingMap.entrySet().stream().max(Map.Entry.comparingByValue()).get()
					.getKey();
			return bestRatingHotel;
		} else if (typeOfMood.equals("cheapHotel")) {
			HotelNameAndCostMap.put("Lakewood", costofLakewood);
			HotelNameAndCostMap.put("Bridgewood", costofBridgewood);
			HotelNameAndCostMap.put("Ridgewood", costofRidgewood);
			String cheapestHotel = HotelNameAndCostMap.entrySet().stream().min(Map.Entry.comparingByValue()).get()
					.getKey();
			return cheapestHotel;
		} else
			return null;
	}

	// Method for finding day of any particular date
	public static String getDayofWeek(String date) throws ParseException {
		SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
		Date dt1 = format1.parse(date);
		DateFormat format2 = new SimpleDateFormat("EE");
		String finalDay = format2.format(dt1);
		return finalDay;
	}
}