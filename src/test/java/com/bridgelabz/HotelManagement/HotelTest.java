package com.bridgelabz.HotelManagement;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;
import java.text.ParseException;
import java.util.ArrayList;

public class HotelTest {
	Hotel hotel = new Hotel();

	@Test
	public void givenDatesOfRangeFor_RegularCustomerSeekingFor_CheapestHotelShouldReturnCheapestHotel()
			throws ParseException {
		ArrayList<String> dates = new ArrayList<>();
		dates.add("3/10/2020");
		dates.add("4/10/2020");
		String result = hotel.calculateprice(dates, "Regular", "cheapHotel");
		Assert.assertEquals("Bridgewood", result);
	}

	@Test
	public void givenDatesOfRangeFor_RewardsCustomerSeekingFor_CheapestHotelShouldReturnCheapestHotel()
			throws ParseException {
		ArrayList<String> dates = new ArrayList<>();
		dates.add("3/10/2020");
		dates.add("4/10/2020");
		String result = hotel.calculateprice(dates, "Rewards", "cheapHotel");
		Assert.assertEquals("Ridgewood", result);
	}

	@Test
	public void givenDatesOfRangeFor_RegularCustomerSeekingForBest_RatedtHotelShouldReturnBestRatedtHotel()
			throws ParseException {
		ArrayList<String> dates = new ArrayList<>();
		dates.add("3/10/2020");
		dates.add("4/10/2020");
		String result = hotel.calculateprice(dates, "Regular", "goodRatingHotel");
		Assert.assertEquals("Ridgewood", result);
	}

	@Test
	public void givenDatesOfRangeFor_RewardsCustomerSeekingForBest_RatedtHotelShouldReturnBestRatedtHotel()
			throws ParseException {
		ArrayList<String> dates = new ArrayList<>();
		dates.add("3/10/2020");
		dates.add("4/10/2020");
		String result = hotel.calculateprice(dates, "Rewards", "goodRatingHotel");
		Assert.assertEquals("Ridgewood", result);
	}

	@Test
	public void givenDatesOfRangeFor_RegulasCustomerSeekingForBest_RatedtHotelThrough_JavaStreamShouldReturnBestRatedtHotel()
			throws ParseException {
		ArrayList<String> dates = new ArrayList<>();
		dates.add("3/10/2020");
		dates.add("4/10/2020");
		String result = hotel.cheapestHotelByStream(dates, "Rewards", "goodRatingHotel");
		Assert.assertEquals("Ridgewood", result);
	}

	@Test
	public void givenDatesOfRangeFor_RewardsCustomerSeekingForBest_RatedtHotelThrough_JavaStreamShouldReturnBestRatedtHotel()
			throws ParseException {
		ArrayList<String> dates = new ArrayList<>();
		dates.add("3/10/2020");
		dates.add("4/10/2020");
		String result = hotel.cheapestHotelByStream(dates, "Rewards", "goodRatingHotel");
		Assert.assertEquals("Ridgewood", result);
	}

	@Test
	public void givenDatesOfRangeFor_RewardsCustomerSeekingFor_CheapestHotelThrough_JavaStreamShouldReturnCheapestHotel()
			throws ParseException {
		ArrayList<String> dates = new ArrayList<>();
		dates.add("3/10/2020");
		dates.add("4/10/2020");
		String result = hotel.cheapestHotelByStream(dates, "Rewards", "cheapHotel");
		Assert.assertEquals("Ridgewood", result);
	}

	@Test
	public void givenDatesOfRangeFor_RegularCustomerSeekingFor_CheapestHotelThroughJavastreamShouldReturnCheapestHotel()
			throws ParseException {
		ArrayList<String> dates = new ArrayList<>();
		dates.add("3/10/2020");
		dates.add("4/10/2020");
		String result = hotel.cheapestHotelByStream(dates, "Regular", "cheapHotel");
		Assert.assertEquals("Bridgewood", result);
	}
}