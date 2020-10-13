package com.bridgelabz.HotelManagement;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;
import java.text.ParseException;
import java.util.ArrayList;

public class HotelTest {
	Hotel hotel=new Hotel();
	@Test
	public void givenDatesOfRangeForRegularCustomerSeekingForCheapestHotelShouldReturnCheapestHotel() throws ParseException {
		ArrayList<String> dates = new ArrayList<>();
		dates.add("3/10/2020");
		dates.add("4/10/2020");
		String result = hotel.calculateprice(dates, "Regular","cheapHotel");
		Assert.assertEquals("Bridgewood", result);
	}
	@Test
	public void givenDatesOfRangeForRewardsCustomerSeekingForCheapestHotelShouldReturnCheapestHotel() throws ParseException {
		ArrayList<String> dates = new ArrayList<>();
		dates.add("3/10/2020");
		dates.add("4/10/2020");
		String result = hotel.calculateprice(dates, "Rewards","cheapHotel");
		Assert.assertEquals("Ridgewood", result);
	}
	@Test
	public void givenDatesOfRangeForRegularCustomerSeekingForBestRatedtHotelShouldReturnBestRatedtHotel() throws ParseException {
		ArrayList<String> dates = new ArrayList<>();
		dates.add("3/10/2020");
		dates.add("4/10/2020");
		String result = hotel.calculateprice(dates, "Regular","goodRatingHotel");
		Assert.assertEquals("Ridgewood", result);
	}
	@Test
	public void givenDatesOfRangeForRewardsCustomerSeekingForBestRatedtHotelShouldReturnBestRatedtHotel() throws ParseException {
		ArrayList<String> dates = new ArrayList<>();
		dates.add("3/10/2020");
		dates.add("4/10/2020");
		String result = hotel.calculateprice(dates, "Rewards","goodRatingHotel");
		Assert.assertEquals("Ridgewood", result);
	}
}