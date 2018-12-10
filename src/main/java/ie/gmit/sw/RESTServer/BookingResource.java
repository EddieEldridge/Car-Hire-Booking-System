package ie.gmit.sw.RESTServer;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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

import javax.ws.rs.GET;
import javax.ws.rs.POST;

@Path("BookingSystem")
public class BookingResource extends BookingObjectMarshaller
{
	// Variables
	private BookingRMIServerImpl bookingServiceImpl;
	BookingObjectMarshaller bom = new BookingObjectMarshaller();

	public BookingResource() throws SQLException, RemoteException
	{
		bookingServiceImpl = new BookingRMIServerImpl();
	}
			
	// Shows all current bookings
	@GET
	@Path("showAllBookings")
	@Produces(MediaType.APPLICATION_XML)
	public String getBookings() 
	{
		// Create a list of BookingObjects to store them in when retrieved from the database
		List<BookingObject> bookingObjects = new ArrayList<BookingObject>();
		List<Booking> bookings = new ArrayList<Booking>();
		
		// Create instances of all our models
		Booking booking = new Booking();
		Customer customer = new Customer();
		Vehicle vehicle = new Vehicle();
		
		// 
		String objectsAsXML = "";
		String objectAsXML;
		String trimmedObjectsAsXML = "";
		int i;
		
		// Get the bookings from the datbaase
		bookingObjects = bookingServiceImpl.getBookings();
				

		
		// Loop through all our bookingObjects and assign the variables from the bookingObject to our local objects
		// These can be located in the BookingModel package
		for(BookingObject bo : bookingObjects)
		{
			booking.setBookingID(bo.getBookingID());
			booking.setCustomerID(bo.getCustomerID());
			booking.setCarID(bo.getCarID());
			booking.setBookingStartDate(bo.getBookingStartDate());
			booking.setBookingEndDate(bo.getBookingEndDate());
			booking.setCarRegistration(bo.getCarRegistration());
			
			bookings.add(booking);
		}
		
		System.out.println("//////////// BOOKING OBJECSTS IN RESOURCE");
		System.out.println(bookingObjects);
		
		System.out.println("Succesfully extracted info from remote object.");
		
		try
		{
			// Create variable to assign to XML
			for(i=0; i<bookings.size(); i++)
			{
				objectAsXML = marshalBooking(bookings.get(i));
				objectsAsXML = objectAsXML.concat(objectAsXML);

				// Trim off the header from the XML as its upsetting the formatting
				/*
				if(i>0)
				{
					trimmedObjectsAsXML = objectAsXML.substring(objectAsXML.indexOf('\n')+1);
					objectsAsXML = objectAsXML.concat(trimmedObjectsAsXML);
				}
				*/
				
			}
			
			System.out.println("Succesfully marshalled to XML.");

		} 
		catch (Exception e)
		{
			System.out.println("Error trying to call marshalBooking..." + e);
		}
		
		System.out.println(objectsAsXML);

		// Return the objects as XML
		return objectsAsXML;
	}
	
	// Creates a booking
	@POST
	@Path("createBooking")
	public BookingObject createBooking(BookingObject booking1)
	{
		try
		{
			bookingServiceImpl.createBooking(booking1);
		} 
		catch (RemoteException e)
		{
			System.out.println("Resource Error: " + e);
		}
		
		// Return the createdBooking
		return booking1;
	}
	
	// Shows bookings with a specified ID
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("booking/{orderID}")
	public BookingObject getBooking(@PathParam("orderID") int orderID) 
	{
		try
		{
			return bookingServiceImpl.getBooking(orderID);
		} 
		catch (RemoteException e)
		{
			System.out.println("Resource Error: " + e);
		}
		return null;
	}
	
	
}


