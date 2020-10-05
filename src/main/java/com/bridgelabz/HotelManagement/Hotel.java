package com.bridgelabz.HotelManagement;
import java.util.*;
import java.text.*;
public class Hotel {
    public  String hotelname;
    public  int weekdayrate;
    public  int weekendrate;
    static  int costofLake;
    static  int costofBridge;
    static int  getCostofRidge;
    int rating;

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
    public static void main(String[] args) throws ParseException {
        Hotel h1= new Hotel("Lakewood",110,90,3);
          Hotel h2= new Hotel("Bridgewood",150,50,4);
          Hotel h3= new Hotel("Ridgewood",220,150,5);
    }
}