package com.ds.DistributedSystemsG00337490;

import java.sql.Connection;
import java.sql.DriverManager;

public class BookingClient
{
	public static void main(String[] args)
	{
		// Variables
		String url = "jdbc:mysql://localhost:3306";
		String username = "root";
		String password = "osgard100";

		// Create a connection;
		try
		{
			Class.forName("com.sql.jdbc.Driver");
			
			// Setup connection to database
			Connection connection = DriverManager.getConnection(url, username, password);
		}
		catch(Exception e)
		{
			System.out.println("Error creating the connection to SQL Server:" + e);
		}
	}
	
}
