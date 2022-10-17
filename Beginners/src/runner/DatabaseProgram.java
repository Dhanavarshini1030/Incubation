package runner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseProgram 
{

	public static Connection getConnection() 
	{
		String DB_URL="jdbc:mysql://localhost/incubationDB";
		String userName="root";
		String password="Root@123";
		Connection connect=null;
		try {
			connect=DriverManager.getConnection(DB_URL, userName, password);
			if(connect!=null)
			{
				System.out.println("DB Connected");
			}
			else
			{
				System.out.println("Not Connected");
			}
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return connect;
		
	}

}
