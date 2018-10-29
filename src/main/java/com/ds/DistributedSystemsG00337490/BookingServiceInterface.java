package com.ds.DistributedSystemsG00337490;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface BookingServiceInterface extends Remote
{
	// Declare booking methods
	public List<Booking> getBookings() throws RemoteException;
	
	public Booking getBooking(int orderID) throws RemoteException;
	
	public void createBooking(Booking booking) throws RemoteException;



}
