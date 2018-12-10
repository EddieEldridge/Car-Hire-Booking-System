package ie.gmit.sw.RESTServer;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import ie.gmit.sw.BookingModel.Booking;
import ie.gmit.sw.BookingModel.Customer;
import ie.gmit.sw.BookingModel.Vehicle;
import ie.gmit.sw.RMIServer.BookingObject;
import ie.gmit.sw.RMIServer.BookingRMIServerImpl;
import ie.gmit.sw.XMLMarshaller.BookingObjectMarshaller;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;

@Path("BookingSystem")
public class BookingResource extends BookingObjectMarshaller
{
	// Variables
	private BookingRMIServerImpl bookingServiceImpl;
	BookingObjectMarshaller bom = new BookingObjectMarshaller();

	// Constructor
	public BookingResource() throws SQLException, RemoteException
	{
		bookingServiceImpl = new BookingRMIServerImpl();
	}
	
	
	// Gets the booking ID from the user for the getBooking method
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("getBookingID")
	public Response getBookingID(@FormParam("bookingID")String bookingID)
	{		
		// Parse the bookingID to an integer
		int parsedBookingID = Integer.parseInt(bookingID);
				
		// Call the getBooking method with the bookingID we just got from the jsp page
		try
		{
			getBooking(parsedBookingID);
		} 
		catch (SQLException e)
		{
			System.out.println("User input error");
		}
		return Response.ok().build();
	}
	
	// Shows all current bookings
	@GET
	@Path("showAllBookings")
	@Produces(MediaType.APPLICATION_XML)
	public List<Booking> getBookings() 
	{
		// Create a list of BookingObjects to store them in when retrieved from the database
		List<BookingObject> bookingObjects = new ArrayList<BookingObject>();
		List<Booking> bookings = new ArrayList<Booking>();
		
		// Create instances of all our models
		Customer customer = new Customer();
		Vehicle vehicle = new Vehicle();
		
		
		// Get the bookings from the datbaase
		bookingObjects = bookingServiceImpl.getBookings();
				
		// Loop through all our bookingObjects and assign the variables from the bookingObject to our local objects
		// These can be located in the BookingModel package
		for(BookingObject bo : bookingObjects)
		{
			Booking booking = new Booking();

			booking.setBookingID(bo.getBookingID());
			booking.setCustomerID(bo.getCustomerID());
			booking.setCarID(bo.getCarID());
			booking.setBookingStartDate(bo.getBookingStartDate());
			booking.setBookingEndDate(bo.getBookingEndDate());
			booking.setCarRegistration(bo.getCarRegistration());
			
			bookings.add(booking);
		}
		
		System.out.println("Succesfully extracted info from remote object.");
		
		/*
		try
		{
			// Create variable to assign to XML
			for(i=0; i<bookings.size(); i++)
			{
				Booking bookingToMarshal = bookings.get(i);
				
				objectAsXML = marshalBooking(bookingToMarshal);
				
				objectsAsXML = objectAsXML.concat(objectAsXML);

				// Trim off the header from the XML as its upsetting the formatting
				if(i>0)
				{
					trimmedObjectsAsXML = objectAsXML.substring(objectAsXML.indexOf('\n')+1);
					objectsAsXML = objectAsXML.concat(trimmedObjectsAsXML);
				}
				
			}
			
		
			System.out.println("Succesfully marshalled to XML.");

		} 
		catch (Exception e)
		{
			System.out.println("Error trying to call marshalBooking..." + e);
		}
			*/
		System.out.println(bookings);

		// Return the objects as XML
		return bookings;
	}
	
	// Shows bookings with a specified ID
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("getBooking")
	public BookingObject getBooking(int bookingID) throws SQLException 
	{	
		// Get the booking from the database by remotely invoking our remote method we setup
		try
		{
			return bookingServiceImpl.getBooking(bookingID);
		} 
		catch (RemoteException e)
		{
			System.out.println("Resource Error: " + e);
		}
		
		System.out.println("Couldn't find booking.");
		return null;
	}
	
	// Deletes bookings with a specified ID
	@DELETE
	@Path("deleteBooking/{bookingID}")
	public void deleteBooking(@PathParam("bookingID") int bookingID) throws SQLException 
	{
		try
		{
			bookingServiceImpl.deleteBooking(bookingID);
		} 
		catch (RemoteException e)
		{
			System.out.println("Resource Error: " + e);
		}
		
	}
	
	// Gets the booking ID from the user for the delteBooking method
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("getBookingIDForDeletion")
	public Response getBookingIDForDeletion(@FormParam("bookingID")String bookingID)
	{		
		int parsedBookingID = Integer.parseInt(bookingID);
				
		try
		{
			deleteBooking(parsedBookingID);
		} 
		catch (SQLException e)
		{
			System.out.println("User input error");
		}
		return Response.ok().build();
	}
	
	// Creates a booking
	@POST
	@Path("createBooking")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	// Take in the paramaters from the URL (the fields the user filled in when they went to create a booking)
	public Response createBooking(
			@FormParam("bookingID")String bookingID,
			@FormParam("customerID")String customerID,
			@FormParam("carID")String carID,
			@FormParam("bookingStartDate")String bookingStartDate,
			@FormParam("bookingEndDate")String bookingEndDate,
			@FormParam("carRegistration")String carRegistration
			)
	{		
		System.out.println("Inside POST METHOD");

		// Create instance of booking to assign values from jsp		
		BookingObject bookingObjectToStoreInDB = new BookingObject();
		
		// Turn the string values into ints
		int newBookingID = Integer.parseInt(bookingID);
		int newCustomerID = Integer.parseInt(customerID);
		int newCarID = Integer.parseInt(carID);
		int newCarRegistration = Integer.parseInt(carRegistration);
		
		// Map the variables taken in from the user to a booking object
		bookingObjectToStoreInDB.setBookingID(newBookingID);
		bookingObjectToStoreInDB.setCustomerID(newCustomerID);
		bookingObjectToStoreInDB.setCarID(newCarID);
		bookingObjectToStoreInDB.setBookingStartDate(bookingStartDate);
		bookingObjectToStoreInDB.setBookingEndDate(bookingEndDate);
		bookingObjectToStoreInDB.setCarRegistration(newCarRegistration);
		
		try
		{
			// Send the mapped object to the RMI Server to be read in to the database
			bookingServiceImpl.createBooking(bookingObjectToStoreInDB);
		} 
		catch (RemoteException e)
		{
			System.out.println("Resource Error: " + e);
		}
		
		return Response.ok().build();
	}
}


