<html>
<body>
    <h2>Welcome to Eddie's Car Hire Booking Service!</h2>
	<form action="webapi/BookingSystem/showAllBookings"><input type="submit" value="Show All Bookings"/></form>
	<form action="createBooking.jsp"><input type="submit" value="Create Booking"/></form>
	<form action="deleteBooking.jsp"><input type="submit" value="Delete Booking"/></form>
	
	
	<form action = "http://localhost:8080/DistributedSystemsG00337490/webapi/BookingSystem/getBookingID" method = "post" enctype="application/x-www-form-urlencoded">
	<input type="text" name="bookingID"/> 	<input type="submit" value="Get Booking"/>
	</form>

</body>
</html>
