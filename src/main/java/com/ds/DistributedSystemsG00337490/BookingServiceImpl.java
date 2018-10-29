package com.ds.DistributedSystemsG00337490;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
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

	// Create a connection;
	try
	{
		Class.forName("com.sql.jdbc.Driver");
		connection = DriverManager.getConnection(url, username, password);
	}
	catch(
	Exception e)
	{
		System.out.println("Error creating the connection to SQL Server:" + e);
	}

	// Setup Hibernate
	Configuration config = new Configuration();

	// Create an instance of sessionFactory so we can create a session
	SessionFactory sessionFactory = config.buildSessionFactory();

	// Create a session from our sessionFactory interface
	Session session = sessionFactory.openSession();

	// Setup connection to database
	Connection connection = null;

	public FileServiceImpl() throws RemoteException
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public BookingServiceImpl() throws RemoteException
	{

	}

	// Shows all current bookings
	public List<Booking> getBookings()
	{
		List<Booking> bookings = new ArrayList();
		String sql = "select * from bookings";
		return bookings;
	}

	// Shows bookings with a specified ID
	@Override
	public Booking getBooking(int orderID) throws RemoteException
	{

		for (Booking booking : bookings)
		{
			if (booking.getOrderID() == orderID)
			{
				System.out.println("Booking found!");
				return booking;
			} else
			{
				return null;
			}
		}

	}

	// Create a booking
	@Override
	public void createBooking(Booking booking) throws RemoteException
	{
		// bookings.add(booking3);
	}

}
