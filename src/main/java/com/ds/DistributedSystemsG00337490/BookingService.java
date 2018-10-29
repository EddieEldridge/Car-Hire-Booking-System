package com.ds.DistributedSystemsG00337490;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

// Booking Service
// This class serves as the gateway for our booking client to 
public class BookingService
{
	public static void main(String[] args) throws Exception
	{
		// Create instance of bookingService implementation
		BookingServiceImpl bookingService = new BookingServiceImpl();
		
		// Start the RMI Registry 
		LocateRegistry.createRegistry(1099);
	}
	
	// Bind the bookingService object to the registry 
	try
	{
		Naming.rebind("bookingService", bookingService);
		System.out.println("Server started...");
	}
	catch(Exception e)
	{
		System.out.println("Server error: " + e);
	}
	
}
