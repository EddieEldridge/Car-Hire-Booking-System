package com.ds.DistributedSystemsG00337490;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BookingServiceImpl extends UnicastRemoteObject implements BookingServiceInterface
{
	public BookingServiceImpl() throws RemoteException
	{
		super();
	}
}
