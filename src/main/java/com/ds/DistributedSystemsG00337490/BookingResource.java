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
	// Variables
	BookingRepository repo = new BookingRepository();
	
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Booking> getBookings() 
	{
		System.out.println("Inside getBookings!");
		return repo.getBookings();
	}
	
	/*
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Booking getBooking() 
	{
		System.out.println("Inside getBooking!");
		return repo.getBooking(20);
	}
	*/
	
}


