package com.ds.DistributedSystemsG00337490;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;

@Path("BookingSystem")
public class BookingResource 
{
	// Variables
	BookingRepository repo = new BookingRepository();
	
	// Shows all current bookings
	@GET
	@Path("showAllBookings")
	@Produces(MediaType.APPLICATION_XML)
	public List<Booking> getBookings() 
	{
		System.out.println("Inside getBookings!");
		return repo.getBookings();
	}
	
	// Creates a booking
	@POST
	@Path("createBooking")
	public Booking createBooking(Booking booking1)
	{
		System.out.println(booking1);
		repo.createBooking(booking1);
		return booking1;
	}
	
	// Shows bookings with a specified ID
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("booking/{orderID}")
	public Booking getBooking(@PathParam("orderID") int orderID) 
	{
		return repo.getBooking(orderID);
	}
	
	
}


