package com.bridgelabz.HotelManagement;
import java.util.*;

import java.text.*;
public class Hotel {
    public  String hotelname;
    public int weekdayrate;
    public int weekendrate;
    static  int costofLakewood;
    static  int costofBridgewood;
    static int CostofRidgewood;
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
    public static String calculateprice(ArrayList<String> list,String customer) throws ParseException{
    	 Iterator<String > it= list.iterator();
         
		if(customer.equals("Regular")) {
             while (it.hasNext()) {
                 String day = getDayofWeek(it.next());
                 if (day.equals("Sun") || day.equals("Sat")) {
                     costofLakewood += 90;
                     costofBridgewood += 60;
                     CostofRidgewood += 150;
                 } else {
                     costofLakewood += 110;
                     costofBridgewood += 150;
                     CostofRidgewood += 220;
                 }
             }
         }
         else
         {
             while (it.hasNext()) {
                 String day = getDayofWeek(it.next());
                 if (day.equals("Sun") || day.equals("Sat")) {
                     costofLakewood += 80;
                     costofBridgewood += 50;
                     CostofRidgewood += 40;
                 } else {
                     costofLakewood += 80;
                     costofBridgewood += 110;
                     CostofRidgewood += 100;
                 }
             }
         }
    	
		int result=min(costofLakewood,costofBridgewood,CostofRidgewood);
		if(result==costofLakewood) {
            System.out.println("Cost is: " + result);
            return "Lakewood";
        }
        else if(result==costofBridgewood) {
            System.out.println("Cost is: " + result);
            return "Bridgewood";
        }
        else {
            System.out.println("Cost is: " + result);
            return "Ridgewood";
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
    public static String getDayofWeek(String date) throws ParseException {
    	SimpleDateFormat format1=new SimpleDateFormat("dd/MM/yyyy");
        Date dt1=format1.parse(date);
        DateFormat format2=new SimpleDateFormat("EE");
        String finalDay=format2.format(dt1);
        return  finalDay;
    }
    public static void main(String[] args) throws ParseException {
    	  Scanner userInput=new Scanner(System.in);
    	  Display();
    	  ArrayList<String> dates=new ArrayList<>();
          dates.add("3/10/2020");
          dates.add("4/10/2020");
    	  h1_regular= new Hotel("Lakewood",110,90,3);
          h1_rewards =new Hotel("Lakewood",80,80,3);
          h2_regular= new Hotel("Bridgewood",150,60,4);
          h2_rewards= new Hotel("Bridgewood",110,50,4);
          h3_regular= new Hotel("Ridgewood",220,150,5);
          h3_rewards= new Hotel("Ridgewood",100,40,5);
          System.out.println("Enter Whether Rewards or Regular");
          String customertype=userInput.nextLine();
          String result=calculateprice(dates,customertype);
          System.out.println(result);
    }
}