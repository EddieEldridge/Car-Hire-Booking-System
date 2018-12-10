package ie.gmit.sw.RMIServer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

public interface BookingRMIServerInterface extends Remote
{
	// Declare booking methods
	public List<BookingObject> getBookings() throws RemoteException;
	
	public BookingObject getBooking(int orderID) throws RemoteException, SQLException;
	
	public void createBooking(BookingObject booking) throws RemoteException;

	void deleteBooking(BookingObject booking) throws RemoteException;

	void deleteBooking(int bookingID) throws RemoteException;

}
