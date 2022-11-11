
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection 
{
	public static Connection getConnection() throws SQLException 
	{
			String DB_URL="jdbc:mysql://localhost:3306/Bank_DB";	
			String userName="root";
			String password="Root@123";
			Connection connection=null;
			try 
			{
				connection=DriverManager.getConnection(DB_URL,userName, password);
				//System.out.println(connection);
				
				if(connection!=null)
				{
					System.out.println("");
				}
				else
				{
					System.out.println("Not Connected");
				}
				
				
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			return connection;
			
		}

	}
