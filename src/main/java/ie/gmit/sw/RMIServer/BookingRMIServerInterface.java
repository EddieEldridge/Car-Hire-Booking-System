package ie.gmit.sw.RMIServer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface BookingRMIServerInterface extends Remote
{
	// Declare booking methods
	public List<BookingObject> getBookings() throws RemoteException;
	
	public BookingObject getBooking(int orderID) throws RemoteException;
	
	public void createBooking(BookingObject booking) throws RemoteException;

}
