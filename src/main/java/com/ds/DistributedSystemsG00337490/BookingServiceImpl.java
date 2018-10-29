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
	private static final long serialVersionUID = 1L;

	public BookingServiceImpl() throws RemoteException
	{
		super();
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
