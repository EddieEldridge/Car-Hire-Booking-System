package com.ds.DistributedSystemsG00337490;

import java.util.ArrayList;
import java.util.List;

public class BookingRepository 
{	
	// Variables
	List<Booking> bookings;
	
	public BookingRepository() 
	{
		bookings = new ArrayList<>();

		Booking booking1 = new Booking();
		booking1.setOrderID(20);
		booking1.setFirstName("Eddie");
		booking1.setLastName("Eldridge");
		booking1.setOrderCost(200.30);
		booking1.setCarName("Golf");
		booking1.setCarRegistration("18-07-1992");

		Booking booking2 = new Booking();
		booking2.setOrderID(21);
		booking2.setFirstName("Kazuya");
		booking2.setLastName("Haliday");
		booking2.setOrderCost(200.30);
		booking2.setCarName("Golf");
		booking2.setCarRegistration("18-07-1992");
		
		Booking booking3 = new Booking();
		booking3.setOrderID(22);
		booking3.setFirstName("Brian");
		booking3.setLastName("Haliday");
		booking3.setOrderCost(200.30);
		booking3.setCarName("Mustang");
		booking3.setCarRegistration("18-07-1992");

		bookings.add(booking1);
		bookings.add(booking2);

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
