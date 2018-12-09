CREATE DATABASE testSystem;

USE bookingSystem1;

CREATE TABLE Customer
(
    customerID INT NOT NULL PRIMARY KEY,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL,
    insuranceID INT(50) NOT NULL,
    customerAdrress VARCHAR(50) NOT NULL
);

CREATE TABLE Booking
(
    customerID INT NOT NULL PRIMARY KEY,
    bookingStartDate VARCHAR(50) NOT NULL,
    bookingEndDate VARCHAR(50) NOT NULL,
    carRegistration INT(50) NOT NULL
);

CREATE TABLE Vehicle
(
    carRegistration INT NOT NULL PRIMARY KEY,
    carManufacturer VARCHAR(50) NOT NULL,
    carModel VARCHAR(50) NOT NULL,
    carColour VARCHAR(50) NOT NULL,
    carEngineSize INT(50) NOT NULL
);
GO