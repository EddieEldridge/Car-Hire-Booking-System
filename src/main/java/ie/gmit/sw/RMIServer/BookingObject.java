package ie.gmit.sw.RMIServer;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import ie.gmit.sw.BookingModel.Booking;

@XmlRootElement
@XmlSeeAlso(Booking.class)
public class BookingObject implements Serializable
{
	private static final long serialVersionUID = 7877428345616246401L;
	
	// Variables
	private int customerID;
	private String bookingStartDate;
	
	public BookingObject(int customerID, String bookingStartDate, String bookingEndDate, int carRegistration)
	{
		super();
		this.customerID = customerID;
		this.bookingStartDate = bookingStartDate;
		this.bookingEndDate = bookingEndDate;
		this.carRegistration = carRegistration;
	}


	private String bookingEndDate;
	private int carRegistration;
	
	/**
	 * @return the customerID
	 */
	public int getCustomerID()
	{
		return customerID;
	}


	/**
	 * @param customerID the customerID to set
	 */
	public void setCustomerID(int customerID)
	{
		this.customerID = customerID;
	}


	/**
	 * @return the bookingStartDate
	 */
	public String getBookingStartDate()
	{
		return bookingStartDate;
	}


	/**
	 * @param bookingStartDate the bookingStartDate to set
	 */
	public void setBookingStartDate(String bookingStartDate)
	{
		this.bookingStartDate = bookingStartDate;
	}


	/**
	 * @return the bookingEndDate
	 */
	public String getBookingEndDate()
	{
		return bookingEndDate;
	}


	/**
	 * @param bookingEndDate the bookingEndDate to set
	 */
	public void setBookingEndDate(String bookingEndDate)
	{
		this.bookingEndDate = bookingEndDate;
	}


	/**
	 * @return the carRegistration
	 */
	public int getCarRegistration()
	{
		return carRegistration;
	}


	/**
	 * @param carRegistration the carRegistration to set
	 */
	public void setCarRegistration(int carRegistration)
	{
		this.carRegistration = carRegistration;
	}


	public BookingObject()
	{
		
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "BookingObject [customerID=" + customerID + ", bookingStartDate=" + bookingStartDate
				+ ", bookingEndDate=" + bookingEndDate + ", carRegistration=" + carRegistration + "]";
	}


}
