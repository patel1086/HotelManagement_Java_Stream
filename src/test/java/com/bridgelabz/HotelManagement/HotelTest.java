package com.bridgelabz.HotelManagement;
import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;
import java.text.ParseException;
import java.util.ArrayList;

public class HotelTest {
	Hotel h= new Hotel("BridgeWood",100,200,1);
    @Test
    public void given_both_weekend_dates_should_return_true() throws ParseException {
        //Hotel h1= new Hotel("BridgeWood",100,200,1);
    	
        ArrayList<String> dates=new ArrayList<>();
        dates.add("3/10/2020");
        dates.add("4/10/2020");
        String result=Hotel.calculateprice(dates,"Regular");
        Assert.assertEquals("Bridgewood",result);

    }

   

}