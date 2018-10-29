package com.ds.DistributedSystemsG00337490;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BookingServiceImpl extends UnicastRemoteObject implements BookingServiceInterface
{
	// Variables
	String url = "jdbc:mysql://localhost:3306";
	String username = "root";
	String password = "osgard100";

	private static final long serialVersionUID = 1L;

	public BookingServiceImpl() throws RemoteException
	{
		super();
	}

	// Shows all current bookings
	public List<Booking> getBookings()
	{
		List<Booking> bookings = new ArrayList();

		// Create a connection;
		try
		{
			// Define we want to use sql jdbc driver
			Class.forName("com.sql.jdbc.Driver");

			// Setup connection to database
			Connection connection = DriverManager.getConnection(url, username, password);

			Statement statement = connection.createStatement();
		} 
		catch (Exception e)
		{
			System.out.println("Error creating the connection to SQL Server:" + e);
		}

		// Create the sql statement we went to execute on our
		String sql = "select * from bookings";

		return bookings;
	}

	// Shows bookings with a specified ID
	@Override
	public Booking getBooking(int orderID) throws RemoteException
	{
		// Create a connection;
		try
		{
			// Define we want to use sql jdbc driver
			Class.forName("com.sql.jdbc.Driver");

			// Setup connection to database
			Connection connection = DriverManager.getConnection(url, username, password);

			Statement statement = connection.createStatement();
		} 
		catch (Exception e)
		{
			System.out.println("Error creating the connection to SQL Server:" + e);
		}

		for (Booking booking : bookings)
		{
			if (booking.getOrderID() == orderID)
			{
				System.out.println("Booking found!");
				return booking;
			} 
			else
			{
				return null;
			}
		}

	}

	// Create a booking
	@Override
	public void createBooking(Booking booking) throws RemoteException
	{
		// Create a connection;
		try
		{
			// Define we want to use sql jdbc driver
			Class.forName("com.sql.jdbc.Driver");

			// Setup connection to database
			Connection connection = DriverManager.getConnection(url, username, password);

			Statement statement = connection.createStatement();
		}
		catch (Exception e)
		{
			System.out.println("Error creating the connection to SQL Server:" + e);
		}
		// bookings.add(booking3);
	}

}
