package com.bridgelabz.HotelManagement;
import java.util.*;

import java.text.*;
public class Hotel {
    public  String hotelname;
    public int weekdayrate;
    public int weekendrate;
    public int costofLakewood;
    public int costofBridgewood;
    public int  getCostofRidgewood;
	public static Hotel h1_regular;
	public static Hotel h2_regular;
	public static Hotel h3_regular;
	public static Hotel h1_rewards;
	public static Hotel h2_rewards;
	public static Hotel h3_rewards;
    int rating;
    
    HashMap<String,ArrayList<Hotel>> hotel=new HashMap<String,ArrayList<Hotel>>();
    
    public static void Display()
    {
        System.out.println("Welcome to Hostel Reservation System");
    }
    public Hotel(String hotelname,int weekdayrate, int weekendrate,int rating) {
        this.hotelname = hotelname;
        this.weekdayrate=weekdayrate;
        this.weekendrate=weekendrate;
        this.rating=rating;
    }
    
    public static int calculateprice(String customer) throws ParseException {
    	int cost=0;
    	if(customer.equals("Regular"))
    	{
    	    cost=min(h1_regular.weekdayrate,h2_regular.weekdayrate,h3_regular.weekdayrate);
    		return cost;
    	}
    	else if(customer.equals("Rewards"))
    	{
    		cost=min(h1_rewards.weekdayrate,h2_rewards.weekdayrate,h3_rewards.weekdayrate);
    		return cost;
    	}
    	else
    	{
    		System.out.println("Please enter correct customer type 1. Regular or 2. Rewards");
    		return cost;
    	}
    	
    }
    public static int min(int price_L,int price_B,int price_R)
    {
    	if(price_L<price_B && price_L<price_R)
    		return price_L;
    	else if(price_B<price_L && price_B<price_R)
    		return price_B;
    	else if(price_R<price_L && price_R<price_B)
    		return price_R;
    	else if(price_L==price_B && price_B<price_R)
    		return price_L;
    	else if(price_L==price_R && price_L<price_B)
    		return price_L;
    	else
    		return price_R;
    }
    public static void main(String[] args) throws ParseException {
    	  Scanner userInput=new Scanner(System.in);
    	  Display();
    	  h1_regular= new Hotel("Lakewood",110,90,3);
          h1_rewards =new Hotel("Lakewood",80,80,3);
          h2_regular= new Hotel("Bridgewood",150,60,4);
          h2_rewards= new Hotel("Bridgewood",110,50,4);
          h3_regular= new Hotel("Ridgewood",220,150,5);
          h3_rewards= new Hotel("Ridgewood",100,40,5);
          System.out.println("Enter Whether Rewards or Regular");
          String customertype=userInput.nextLine();
          int result=calculateprice(customertype);
          //calculating cost for one day period
          if(result==h1_regular.weekdayrate || result==h1_rewards.weekdayrate)
        	  System.out.println(h1_regular.hotelname+" "+result);
          else if(result==h2_regular.weekdayrate || result==h2_rewards.weekdayrate)
        	  	   System.out.println(h2_regular.hotelname+" "+result);
          else
        	  System.out.println(h3_regular.hotelname+" "+result);
    }
}