package com.bridgelabz.HotelManagement;

import org.junit.Assert;
import org.junit.Test;
import java.text.ParseException;
import java.util.*;

public class HotelTest {
	// Hotel hotel=new Hotel("HotelName","RegularWeekDayRate","RegularWeekEndRate","RewardsWeekDayRate","RewardsWeekEndRate","Rating")
	Hotel hotel1 = new Hotel("Lakewood", 110, 90, 80, 80, 3);
	Hotel hotel2 = new Hotel("Bridgewood", 160, 60, 110, 50, 4);
	Hotel hotel3 = new Hotel("Ridgewood", 220, 150, 100, 40, 5);

	@Test
	public void givenDatesOfRange_ForRegularCustomer_ShouldReturnCheapestHotel() throws ParseException {
		ArrayList<String> dates = new ArrayList<>();
		dates.add("3/10/2020");
		dates.add("4/10/2020");
		hotel1.calculateprice(dates, "Regular");
		hotel2.calculateprice(dates, "Regular");
		hotel3.calculateprice(dates, "Regular");
		String result = hotel1.findCheapestHotel();
		Assert.assertEquals("Bridgewood", result);
	}

	@Test
	public void givenDatesOfRange_ForRewardsCustomer_ShouldReturnCheapestHotel() throws ParseException {
		ArrayList<String> dates = new ArrayList<>();
		dates.add("3/10/2020");
		dates.add("4/10/2020");
		hotel1.calculateprice(dates, "Rewards");
		hotel2.calculateprice(dates, "Rewards");
		hotel3.calculateprice(dates, "Rewards");
		String result = hotel1.findCheapestHotel();
		Assert.assertEquals("Ridgewood", result);
	}

	@Test
	public void givenDatesOfRange_ForHotelLakeWoodRegularCustomer_ShouldReturnTotalCost() throws ParseException {
		ArrayList<String> dates = new ArrayList<>();
		dates.add("3/10/2020");
		dates.add("4/10/2020");
		int result = hotel1.calculateprice(dates, "Regular");
		Assert.assertEquals(180, result);
	}

	@Test
	public void givenDatesOfRange_ForHotelLakeWoodRewardsCustomer_ShouldReturnTotalCost() throws ParseException {
		ArrayList<String> dates = new ArrayList<>();
		dates.add("3/10/2020");
		dates.add("4/10/2020");
		int result = hotel1.calculateprice(dates, "Rewards");
		Assert.assertEquals(160, result);
	}

	@Test
	public void givenDatesOfRange_ForHotelBridgeWoodRegularCustomer_ShouldReturnTotalCost() throws ParseException {
		ArrayList<String> dates = new ArrayList<>();
		dates.add("3/10/2020");
		dates.add("4/10/2020");
		int result = hotel2.calculateprice(dates, "Regular");
		Assert.assertEquals(120, result);
	}

	@Test
	public void givenDatesOfRange_ForHotelBridgeWoodRewardsCustomer_ShouldReturnTotalCost() throws ParseException {
		ArrayList<String> dates = new ArrayList<>();
		dates.add("3/10/2020");
		dates.add("4/10/2020");
		int result = hotel2.calculateprice(dates, "Rewards");
		Assert.assertEquals(100, result);
	}

	@Test
	public void givenDatesOfRange_ForHotelRidgeWoodRegularCustomer_ShouldReturnTotalCost() throws ParseException {
		ArrayList<String> dates = new ArrayList<>();
		dates.add("3/10/2020");
		dates.add("4/10/2020");
		int result = hotel3.calculateprice(dates, "Regular");
		Assert.assertEquals(300, result);
	}

	@Test
	public void givenDatesOfRange_ForHotelRidgeWoodRewardsCustomer_ShouldReturnTotalCost() throws ParseException {
		ArrayList<String> dates = new ArrayList<>();
		dates.add("3/10/2020");
		dates.add("4/10/2020");
		int result = hotel3.calculateprice(dates, "Rewards");
		Assert.assertEquals(80, result);
	}
}