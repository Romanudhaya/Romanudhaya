package com.uda1.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Firstjdbc {
	static String url = "jdbc:mysql://localhost:3306/firstjdbc";
	static String username ="root";
	static String password="udhaya6225@.";
	static Connection con;
	public static Connection connect(){
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}
	
	
	
	public static void closeConnection(ResultSet res,Statement stmt,Connection con) {
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
