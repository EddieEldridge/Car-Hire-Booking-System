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
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL,
    insuranceID INT(50) NOT NULL,
    customerAdrress VARCHAR(50) NOT NULL
);

CREATE TABLE Vehicle
(
    customerID INT NOT NULL PRIMARY KEY,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL,
    insuranceID INT(50) NOT NULL,
    customerAdrress VARCHAR(50) NOT NULL
);
GO