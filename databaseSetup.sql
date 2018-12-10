CREATE DATABASE testSystem8;

USE testSystem8;

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
    bookingID INT NOT NULL PRIMARY KEY,
    customerID INT(50) NOT NULL,
    carID INT(50) NOT NULL,
    bookingStartDate VARCHAR(50) NOT NULL,
    bookingEndDate VARCHAR(50) NOT NULL,
    carRegistration INT(50) NOT NULL
);

-- Insert rows into table 'TableName'
INSERT INTO Booking
( -- columns to insert data into
 bookingID, customerID, carID, bookingStartDate, bookingEndDate, carRegistration
)
VALUES
( -- first row: values for the columns in the list above
 999, 123, 12345, '19th January', '25th January', 12345
),
( -- second row: values for the columns in the list above
 666, 456, 54321,'26th January', '30th January', 54321
);


CREATE TABLE Vehicle
(
    carID INT NOT NULL PRIMARY KEY,
    carManufacturer VARCHAR(50) NOT NULL,
    carRegistration VARCHAR(50) NOT NULL,
    carModel VARCHAR(50) NOT NULL,
    carColour VARCHAR(50) NOT NULL,
    carEngineSize INT(50) NOT NULL
);

-- Insert rows into table 'TableName'
INSERT INTO Vehicle
( -- columns to insert data into
 carID, carManufacturer, carRegistration, carModel, carColour, carEngineSize
)
VALUES
( -- first row: values for the columns in the list above
 12345, 103452, 'Toyota', 'Corolla', 'Red', 2
),
( -- second row: values for the columns in the list above
 54321, 103455, 'Honda', 'Civic', 'Black', 5
);
GO


