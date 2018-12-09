-- Create a new database called 'carBookingSystem'
-- Connect to the 'master' database to run this snippet
USE master
GO
-- Create the new database if it does not exist already
IF NOT EXISTS (
    SELECT name
        FROM sys.databases
        WHERE name = N'carBookingSystem'
)
CREATE DATABASE carBookingSystem
GO

-- Create a new table called 'TableName' in schema 'SchemaName'
-- Drop the table if it already exists
IF OBJECT_ID('carBookingSystem.Customer', 'U') IS NOT NULL
DROP TABLE carBookingSystem.Customer
GO
-- Create the table in the specified schema
CREATE TABLE carBookingSystem.TableName
(
    TableNameId INT NOT NULL PRIMARY KEY, -- primary key column
    Column1 [NVARCHAR](50) NOT NULL,
    Column2 [NVARCHAR](50) NOT NULL
    -- specify more columns here
);
GO