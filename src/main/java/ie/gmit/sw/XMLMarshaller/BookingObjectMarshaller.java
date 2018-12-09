package ie.gmit.sw.XMLMarshaller;

import java.io.StringWriter;

import ie.gmit.sw.BookingModel.Booking;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class BookingObjectMarshaller
{
	public BookingObjectMarshaller()
	{
		
	}
	
	protected String marshalBooking(Booking booking)
	{
		StringWriter stringWriter = new StringWriter();
		Marshaller xmlMarshaller;
		
		// Try and marshal the booking
		try
		{
			JAXBContext jaxb = JAXBContext.newInstance("ie.gmit.sw.BookingModel");
			xmlMarshaller = jaxb.createMarshaller();
			xmlMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			xmlMarshaller.marshal(booking, stringWriter);
		} 
		catch (JAXBException e)
		{
			System.out.println("Error marshalling booking as XML: " + e);
		}
				
		return stringWriter.toString();
	}
}
