package com.ds.DistributedSystemsG00337490;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class BookingRepository 
{	
	// Variables
	
	
	// Setup connection to database
	Connection connection = null;
	
	public BookingRepository() 
	{

		

	}

	// Shows all current bookings
	public List<Booking> getBookings() 
	{
		return bookings;
	}

	// Shows bookings with a specified ID
	public Booking getBooking(int orderID) 
	{
		
		for(Booking booking: bookings)
		{
			if(booking.getOrderID() == orderID)
			{
				System.out.println("Booking found!");
				return booking;
			}
			else
			{
				return null;
			}
		}
		
		return null; 
	}
	
	// Creates a booking
	public void createBooking(Booking booking3)
	{
		bookings.add(booking3);
	}
}
