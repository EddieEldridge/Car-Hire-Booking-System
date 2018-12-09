package ie.gmit.sw.XMLMarshaller;

import java.io.StringReader;
import java.io.StringWriter;

import ie.gmit.sw.BookingModel.Booking;
import ie.gmit.sw.RMIServer.BookingObject;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

public class BookingObjectMarshaller
{
	public BookingObjectMarshaller()
	{
		
	}
	
	// Function to marshal the Java object(Booking) as XML
	public String marshalBooking(BookingObject bookingObjects)
	{
		StringWriter stringWriter = new StringWriter();
		Marshaller xmlMarshaller;
		
		// Try and marshal the booking
		try
		{
			JAXBContext jaxb = JAXBContext.newInstance("ie.gmit.sw.BookingModel");
			
			// Create the unmarshaller
			xmlMarshaller = jaxb.createMarshaller();
			
			// Marshall the booking object as XML
			xmlMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			xmlMarshaller.marshal(bookingObjects, stringWriter);
		} 
		catch (JAXBException e)
		{
			System.out.println("Error marshalling booking as XML: " + e);
		}
		
		// Return the XML generated from the object as a string using our stringWriter
		return stringWriter.toString();
	}
	
	// Function to unmarshal the XML to a Java object(Booking)
	public Booking unmarshalBooking(String xml)
	{
		StringReader stringReader = new StringReader(xml);
		Unmarshaller xmlUnmarshaller;
		
		Booking bookingToUnmarshal = null;
		
		// Try and unmarshal the booking
		try
		{
			JAXBContext jaxb = JAXBContext.newInstance("ie.gmit.sw.BookingModel");
			
			// Create the unmarshaller
			xmlUnmarshaller = jaxb.createUnmarshaller();
			
			// Create a source to read in our XML to
			StreamSource src = new StreamSource(stringReader);
			
			// Using this source of XML, unmarshal the xml to a Booking object
			JAXBElement<Booking> bookingXMLElement = xmlUnmarshaller.unmarshal(src, Booking.class);
			bookingToUnmarshal = (Booking) bookingXMLElement.getValue();
			
		} 
		catch (JAXBException e)
		{
			System.out.println("Error unmarshalling booking as XML: " + e);
		}
				
		// Return the booking object we just unmarshalled
		return bookingToUnmarshal;
	}
}
