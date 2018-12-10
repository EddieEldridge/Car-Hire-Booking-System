<html>
   <head>
      <title>Create a booking</title>
   </head>
   
   <body>
      <center>
      <h1>Using POST Method to Read Form Data</h1>
      
      <ul>
         <li><p><b>Booking ID:</b>
            <%= request.getParameter("bookingID")%>
         </p></li>
         <li><p><b>Customer ID:</b>
            <%= request.getParameter("customerID")%>
         </p></li>
         <li><p><b>Car ID:</b>
            <%= request.getParameter("carID")%>
         </p></li>
         <li><p><b>Booking Start Date:</b>
            <%= request.getParameter("bookingStartDate")%>
         </p></li>
         <li><p><b>Booking End Date:</b>
            <%= request.getParameter("bookingEndDate")%>
         </p></li>
         <li><p><b>Car Registration:</b>
            <%= request.getParameter("carRegistration")%>
         </p></li>
      </ul>
   
   </body>
</html>