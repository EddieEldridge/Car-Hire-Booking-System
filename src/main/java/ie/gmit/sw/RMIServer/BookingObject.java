package ie.gmit.sw.RMIServer;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BookingObject implements Serializable
{
	private static final long serialVersionUID = 7877428345616246401L;
	
	// Variables
	private int customerID;
	private String bookingStartDate;
	private String bookingEndDate;
	private String carRegistration;
	
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



	public BookingObject(int customerID, String bookingStartDate, String bookingEndDate, String carRegistration)
	{
		super();
		this.customerID = customerID;
		this.bookingStartDate = bookingStartDate;
		this.bookingEndDate = bookingEndDate;
		this.carRegistration = carRegistration;
	}



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
	public String getCarRegistration()
	{
		return carRegistration;
	}
	/**
	 * @param carRegistration the carRegistration to set
	 */
	public void setCarRegistration(String carRegistration)
	{
		this.carRegistration = carRegistration;
	}
	

}
