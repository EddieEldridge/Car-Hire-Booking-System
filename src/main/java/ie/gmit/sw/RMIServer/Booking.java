package ie.gmit.sw.RMIServer;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Booking implements Serializable
{
	private static final long serialVersionUID = 7877428345616246401L;
	
	// Variables
	private String firstName;
	private String lastName;
	private double orderCost;
	private int orderID;
	private String carName;
	private String carRegistration;
	private String startOfBooking;
	private String endOfBooking;
	
	public Booking()
	{
		
	}
	
	public Booking(String firstName, String lastName, double orderCost, int orderID, String carName,
			String carRegistration, String startOfBooking, String endOfBooking)
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.orderCost = orderCost;
		this.orderID = orderID;
		this.carName = carName;
		this.carRegistration = carRegistration;
		this.startOfBooking = startOfBooking;
		this.endOfBooking = endOfBooking;
	}
	
	// Getters and Setters
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getOrderCost() {
		return orderCost;
	}
	public void setOrderCost(double orderCost) {
		this.orderCost = orderCost;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCarRegistration() {
		return carRegistration;
	}
	public void setCarRegistration(String carRegistration) {
		this.carRegistration = carRegistration;
	}
	
	public String getEndOfBooking()
	{
		return endOfBooking;
	}
	public void setEndOfBooking(String endOfBooking)
	{
		this.endOfBooking = endOfBooking;
	}
	public String getStartOfBooking()
	{
		return startOfBooking;
	}
	public void setStartOfBooking(String startOfBooking)
	{
		this.startOfBooking = startOfBooking;
	}


	
	
	

}
