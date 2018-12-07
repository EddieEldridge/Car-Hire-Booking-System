package com.ds.DistributedSystemsG00337490;

import java.rmi.ConnectException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class BookingClient
{

	public static void main(String[] args) throws NotBoundException, RemoteException
	{
		try 
		{
			// Getting the registry	
			Registry registry = LocateRegistry.getRegistry(null);
			
			// Create stub
			BookingServiceInterface stub;
			
			try 
			{
				// Looking up registry for remote object
				stub = (BookingServiceInterface) registry.lookup("databaseService");
				
				// Remote methods
				stub.getBooking(1);		
			} 
			catch (Exception e)
			{
				System.out.println("Could not find registry.");
			}
			
					
		}
		
		catch (ConnectException e) 
		{
			System.out.println("Client Connection Exception: " + e);
		}
	}
	
}
