CREATE DATABASE testSystem3;

USE testSystem3;

CREATE TABLE Customer
(
    customerID INT NOT NULL PRIMARY KEY,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL,
    insuranceID INT(50) NOT NULL,
    customerAdrress VARCHAR(50) NOT NULL
);

-- Insert rows into table 'TableName'
INSERT INTO Customer
( -- columns to insert data into
 customerID, firstName, lastName, insuranceID, customerAdrress
)
VALUES
( -- first row: values for the columns in the list above
 123, 'Ed', 'Eldridge', 999, 'Galway'
),
( -- second row: values for the columns in the list above
 456, 'John', 'Christ', 666, 'Dublin'
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