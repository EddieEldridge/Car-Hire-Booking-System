package com.ds.DistributedSystemsG00337490;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class BookingRepository 
{	
	// Variables
	
	
	// Setup connection to database
	Connection connection = null;
	
	public BookingRepository() 
	{
		// Variables
		String url = "jdbc:mysql://localhost:3306";
		String username="root";
		String password = "osgard100";
		
		// Create a connection;
		try
		{
			Class.forName("com.sql.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}

	// Shows all current bookings
	public List<Booking> getBookings() 
	{
		List<Booking> bookings = new ArrayList();
		String sql = "select * from bookings";
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