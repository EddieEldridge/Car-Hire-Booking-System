package com.ds.DistributedSystemsG00337490;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

// Booking Service
// This class serves as the gateway for our booking client to 
public class BookingService
{
	public static void main(String[] args) throws Exception
	{
		// Create instance of bookingService implementation
		BookingServiceImpl bookingServiceImpl = new BookingServiceImpl();
		
		// Export the implementation
		System.setProperty("java.rmi.server.hostname","127.0.0.1:1099");

		// Start the RMI Registry 
		try 
		{
			LocateRegistry.createRegistry(1099);
			System.out.println("Creating registry...");
		} 
		catch (Exception e2)
		{
			System.out.println("Error creating registry: " + e2);
		}
		
		try
		{
			Naming.rebind("databaseService", bookingServiceImpl);
		}
		catch (Exception e2)
		{
			System.out.println("Error binding databaseService: " + e2);
		}
		
		//BookingServiceInterface stub;
		
		try 
		{
			//stub = (BookingServiceInterface) UnicastRemoteObject.exportObject(bookingServiceImpl, 0);
			Naming.rebind("databaseService", bookingServiceImpl);
			System.out.println("Server started...");
		}
		catch (Exception e1) 
		{
			System.out.println("Error exporting remote object: " + e1);
		}
		
		// Bind the bookingService object to the registry 
		try
		{
			
		}
		catch(Exception e)
		{
			System.out.println("Server error: " + e);
		}
	}
	
	
	
}
