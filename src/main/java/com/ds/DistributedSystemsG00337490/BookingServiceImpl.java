package com.ds.DistributedSystemsG00337490;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class BookingServiceImpl extends UnicastRemoteObject implements BookingServiceInterface
{
	// Variables
	String url = "jdbc:mysql://localhost:3306/bookings";
	String username = "root";
	String password = "osgard100";
	Statement statement = null;
	Connection connection = null;
	

	private static final long serialVersionUID = 1L;

	public BookingServiceImpl() throws RemoteException, SQLException
	{
		// Setup connection to database
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
		} 
		catch (Exception e)
		{
			System.out.println("Connection error: "+e);
		}
		


	}

	



	// Shows all current bookings
	public List<Booking> getBookings()
	{

		
		List<Booking> bookings = new ArrayList<>();
		        
		// Create the sql statement we went to execute on our
		System.out.println(url);
		String sql = "show tables;";
		
		try
		{
			Statement statement = connection.createStatement();
		} 
		catch (Exception e1)
		{
			System.out.println("Statement error: "+e1);

		}

		// Execute the statement
        try
		{
        	System.out.println("Executing statement!");
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next())
			{
				System.out.println(rs);
			}
		} 
        catch (SQLException e)
		{
			System.out.println("SQL Error: " +e);
		}
		return bookings;
	}

	// Shows bookings with a specified ID
	@Override
	public Booking getBooking(int orderID) throws RemoteException
	{

		/*
		 * for (Booking booking : bookings) { if (booking.getOrderID() == orderID) {
		 * System.out.println("Booking found!"); return booking; } else { return null; }
		 * }
		 */

		return null;

	}

	// Create a booking
	@Override
	public void createBooking(Booking booking) throws RemoteException
	{
		// bookings.add(booking3);
	}

}
