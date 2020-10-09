package com.bridgelabz.HotelManagement;
import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;
import java.text.ParseException;
import java.util.ArrayList;

public class HotelTest {
	@Test
    public void given_both_weekend_dates_for_regular_should_return_true() throws ParseException {
    	ArrayList<String> dates=new ArrayList<>();
        dates.add("3/10/2020");
        dates.add("4/10/2020");
        String result=Hotel.calculateprice(dates,"Regular");
        Assert.assertEquals("Bridgewood",result);
	}
	@Test
    public void given_both_weekend_dates_for_Rewards_should_return_true() throws ParseException {
    	ArrayList<String> dates=new ArrayList<>();
        dates.add("3/10/2020");
        dates.add("4/10/2020");
        String result=Hotel.calculateprice(dates,"Rewards");
        Assert.assertEquals("Ridgewood",result);
	}
	}