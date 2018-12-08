package ie.gmit.sw.RMIServer;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

// Booking Service
// This class serves as the gateway for our booking client to 
public class BookingRMIServer
{
	public static void main(String[] args) throws Exception
	{
		
		// Create instance of bookingService implementation
		BookingRMIServerImpl bookingServiceImpl = new BookingRMIServerImpl();
		
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
			System.out.println("Server started...");
		}
		catch (Exception e1) 
		{
			System.out.println("Error exporting remote object: " + e1);
		}
	}
}
