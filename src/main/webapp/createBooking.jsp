<html>
   <head>
      <title>Create a booking</title>
   </head>
   
   <body>
      <center>
      <h1>Using POST Method to Read Form Data</h1>
      
     <form action = "http://localhost:8080/DistributedSystemsG00337490/createBooking" method = "post">

        <td>Booking ID:<input type="text" name = "bookingID" value=""/></td>
        <td>Customer ID: <input type="text" name = "customerID" value=""/></td>
        <td>Car ID: <input type="text" name = "carID" value=""/></td>
        <td>Start  Date: <input type="text" name = "bookingStartDate" value=""/></td>
        <td>End Date: <input type="text" name = "bookingEndDate" value=""/></td>
        <td>Car Reg: <input type="text" name = "carRegistration" value="}"/></td>


        <input type="submit" value="Add Booking"/>

    </form>
   
   </body>
</html>