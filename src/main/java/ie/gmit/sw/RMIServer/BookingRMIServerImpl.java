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
	String url = "jdbc:mysql://localhost:3306/bookings";
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
	public List<Booking> getBookings()
	{
		// http://localhost:8080/DistributedSystemsG00337490/webapi/BookingSystem/showAllBookings
		List<Booking> bookings = new ArrayList<>();
		
		System.out.println("Getting all bookings...");
		        
		// Create the sql statement we went to execute on our
		System.out.println(url);
		String sql = "select * from bookings;";
		
		// Execute the statement
        try
		{
			Statement statement = connection.createStatement();
			System.out.println(statement);
        	System.out.println("Executing statement!");
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next())
			{
				String firstName = rs.getString(1);
				String secondName = rs.getString(2);
				int id = rs.getInt(3);

				System.out.println("\nFirst Name: " + firstName + "\nSecond Name: " + secondName + "\nID: " + id);
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
		System.out.println("Getting booking...!");


		return null;

	}

	// Create a booking
	@Override
	public void createBooking(Booking booking) throws RemoteException
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
