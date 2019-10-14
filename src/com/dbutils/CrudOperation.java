package com.dbutils;
import java.sql.*;

public class CrudOperation 
{
	private static Connection con;
	
	public static void closedConnection()
	{
		try {
			if(con!=null)
				con.close();
		}
		catch(SQLException se)
		{
			System.out.println(se);
		}
	}
	
	public static Connection createConnection()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/organisation","root","root1");
		}
		catch(ClassNotFoundException | SQLException cse) {
			System.out.println(cse);
		}
		return con;
	}
	public static void main(String[] args) {
		Connection com = createConnection();
		System.out.println(con);
	}
}
