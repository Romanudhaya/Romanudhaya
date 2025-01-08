package com.uda1.fetcAll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class FetchAll {
		static Connection con;
		static Statement stmt;
		static ResultSet res;
		public static void main(String[] args) {
			String url = "jdbc:mysql://localhost:3306/firstjdbc";
			String username ="root";
			String password="udhaya6225@."; 
			try {
				// 1 Load the Driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				// 2 Establish the connection
				con = DriverManager.getConnection(url, username, password);
				// 3 create the statement
				stmt = con.createStatement();
				// 4 execute the statement
				res = stmt.executeQuery("select*from student");
				// 5 process the data
				while(res.next()) {
					System.out.println(res.getInt(1)+" "+
				             res.getString(2)+" "+
							res.getString(3)+" "+
				             res.getString(4)+" "+
							res.getString(5)
				             );
				}
							
			} 
			catch (ClassNotFoundException | SQLException e) {
							e.printStackTrace();
			}
			
			finally {
				try {
					if(res!=null) {
						res.close();
						System.out.println("resultset is closed");
					}
					if(stmt!=null) {
						stmt.close();
						System.out.println("Statement is closed");
					}
					if(con!=null){
						con.close();
						System.out.println("Connection is closed");
					}
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
	}
}
