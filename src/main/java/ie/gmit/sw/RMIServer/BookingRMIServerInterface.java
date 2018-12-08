package ie.gmit.sw.RMIServer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface BookingRMIServerInterface extends Remote
{
	// Declare booking methods
	public List<Booking> getBookings() throws RemoteException;
	
	public Booking getBooking(int orderID) throws RemoteException;
	
	public void createBooking(Booking booking) throws RemoteException;

}
