

![distributedsystems](https://user-images.githubusercontent.com/22448079/49762395-854b6a80-fcc1-11e8-90a1-b442346b833a.png)


<p align="center">
  <b>A RESTful Car Hire Booking System using JAX-RS/Jersey, Java RMI and JAXB frameworks.
</b><br>
</p>

# Contents
* [Description](#description)
* [How to run](#how-to-run-the-program)
* [Technologies](#technologies)
* [Issues](#issues)

# Description
This project creates a web client page which provieds users the ability to Create/Read/Update and Delete bookings in a bookings database. The web client interacts with a RESTful JAX-RS Web service which is deployed on a Apache Tomcat Server. The RESTful Web Service also acts as an RMI client to the RMI Database Server which will handle persistience and CRUD functionality of the database.


![capture](https://user-images.githubusercontent.com/22448079/49762553-0145b280-fcc2-11e8-850d-46ccf5460f0f.PNG)


The idea behind this project was to get some hands on experience with technologies such as RESTful Web Services, Remote Method Invocation and Data Externalisation.

The project can be broken down into 4 parts

  * Simple Web Client
  * RESTFul Web Service
  * Data Models
  * RMI Database Server


# How to run the program

#### Step 1
Setup the database

```
 mysql -u root -p -s < <the path of the mysql script>>
```

In my case it was 

```
 mysql -u root -p -s < C:\Users\Eddie\Desktop\DistributedSystems-master\databaseSetup.sql
```
This will create and populate the database.

Any problems with the database can be resolved here

![capture](https://user-images.githubusercontent.com/22448079/49764554-ba5abb80-fcc7-11e8-9fd4-045d174a5b50.PNG)

#### Step 2
Import the project into Eclipse (any version will do but make sure it's an <b>Enterprise Edition</b>).

Once imported you need to ensure that you have a Tomcat Server added to the Java Build Path as this will be required to simulate the RMI functionality of the program as well as running the RESTful web service and client.

![capture](https://user-images.githubusercontent.com/22448079/49764016-36ec9a80-fcc6-11e8-81b5-2559129f0b77.PNG)

A Java SDK (not JRE) installation is also recommended. I used Java 1.7 to create this project.

#### Step 3
Once the database is setup, the project has been imported and any errors or problems that exist have been resolved, you can begin to <b>attempt</b> to run the project. Due to the nature of Eclipse, it probably won't work. If it does however import with no errors, you can run the files in the following order

```
Right Click BookingRMIServer > Run as > Java Application
```

```
Right Click BookingRMIServer > Run as > Run on Server
```

```
Right Click DistributedSystemsG00337490 > Run as > Run on Server
```

If all goes well, an index.jsp page should appear.


![capture](https://user-images.githubusercontent.com/22448079/49764091-60a5c180-fcc6-11e8-9acc-e0fd95bbbf69.PNG)

From here you can interact remotely with the database and perform some CRD functionality on the database.

#### Step 4
Navigate to 
```
http://localhost:8080/DistributedSystemsG00337490/
```
in your browser if you would prefer.

Enjoy!
# Issues

* XML does not play well with Firefox therefore Chrome or any alternative should be used if testing in the browser
* I am aware that when trying to view all the bookings from the database, they are only displayed as XML. I was trying to figure out a way to map the XML to HTML/JSP for sometime but could not find a way
* When clicking any of the buttons, a blank page is displayed. However when you return to see all the bookings or check the database, you will see the database has changed.
* Marshalling/Unmarshalling was not used to send and recieve data from RESTful service but the functionality was included if needed in the future

# Technologies
* [JAX-RS](https://en.wikipedia.org/wiki/Java_API_for_RESTful_Web_Services)
* [JAXB](https://www.oracle.com/technetwork/articles/javase/index-140168.html)
* [Jersey](https://jersey.github.io/)
* [Java 1.8](https://www.java.com/en/download/)
* [Tomcat Server](https://tomcat.apache.org/)
* [Eclipse IDE](https://www.eclipse.org/ide/)
* [MySQL Server 5.7](https://dev.mysql.com/downloads/mysql/5.7.html)
* [Maven](https://maven.apache.org/)

# Developers
* [Eddie Eldridge](https://github.com/EddieEldridge)	

