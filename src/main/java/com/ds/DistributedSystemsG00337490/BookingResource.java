package com.ds.DistributedSystemsG00337490;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;

@Path("bookings")
public class BookingResource 
{
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Booking> getBookings() 
	{
		System.out.println("Inside getBooking!");
		
		Booking booking1 = new Booking();
		booking1.setFirstName("Eddie");
		booking1.setLastName("Eldridge");
		booking1.setOrderCost(200.30);
		booking1.setOrderID(20);
		booking1.setCarName("Golf");
		booking1.setCarRegistration("18-07-1992");
		
		Booking booking2 = new Booking();
		booking2.setFirstName("Luke");
		booking2.setLastName("Haliday");
		booking2.setOrderCost(200.30);
		booking2.setOrderID(20);
		booking2.setCarName("Golf");
		booking2.setCarRegistration("18-07-1992");
		
		List<Booking> bookings = Arrays.asList(booking1,booking2);
		return bookings;
	}
}
