package ie.gmit.sw.RMIServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class BookingRMIServerImpl extends UnicastRemoteObject implements BookingRMIServerInterface
{
	// Variables
	String url = "jdbc:mysql://localhost:3306/testSystem8";
	String username = "root";
	String password = "osgard100";
	Statement statement = null;
	Connection connection = null;
	

	private static final long serialVersionUID = 1L;

	public BookingRMIServerImpl() throws RemoteException, SQLException
	{
		// Setup connection to database
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
		} 
		catch (Exception e)
		{
			System.out.println("Connection error to database: "+e);
		}
	}


	// Shows all current bookings
	public List<BookingObject> getBookings()
	{
		// http://localhost:8080/DistributedSystemsG00337490/webapi/BookingSystem/showAllBookings
		
		// Create list to store bookings 
		List<BookingObject> bookingsList = new ArrayList<>();
		
		// Creat booking to add to list of bookings
		BookingObject bookingObject = new BookingObject();
				
		System.out.println("Getting all bookings...");
		        
		// Create the sql statement we went to execute on our
		System.out.println(url);
		String sql = "select * from booking;";
		
		// Execute the statement
        try
		{
			Statement statement = connection.createStatement();
			System.out.println(statement);
        	System.out.println("Executing statement!");
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next())
			{
				// Read in the data from the database to our object
				bookingObject.setBookingID(rs.getInt("bookingID"));
				bookingObject.setCustomerID(rs.getInt("customerID"));
				bookingObject.setCarID(rs.getInt("carID"));
				bookingObject.setBookingStartDate(rs.getString("bookingStartDate"));
				bookingObject.setBookingEndDate(rs.getString("bookingEndDate"));
				bookingObject.setCarRegistration(rs.getInt("carRegistration"));
				
				// Add the booking to our list of bookings retrieved from the database
				bookingsList.add(bookingObject);
			}
			
			System.out.println(bookingsList);
		} 
        catch (SQLException e)
		{
			System.out.println("SQL Error: " +e);
		}
           
        // Returns a list of booking objects from the database
		return bookingsList;
	}

	// Shows bookings with a specified ID
	@Override
	public BookingObject getBooking(int orderID) throws RemoteException
	{

		/*
		 * for (Booking booking : bookings) { if (booking.getOrderID() == orderID) {
		 * System.out.println("Booking found!"); return booking; } else { return null; }
		 * }
		 */
		System.out.println("Getting booking...!");


		return null;

	}

	// Create a booking
	@Override
	public void createBooking(BookingObject booking) throws RemoteException
	{
		// Create the sql statement we went to execute on our
		// INSERT INTO bookings(firstName, secondName, ID) VALUES ("Eddie", "Eldridge", 5);
		System.out.println(url);
		String sql = "insert into bookings(firstName, lastName, ID) VALUES ('Jesus', 'Christ', '100');";
				
		System.out.println("Creating booking...!");
		// Execute the statement
        try
		{
			Statement statement = connection.createStatement();
			System.out.println(statement);
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
	}

}
