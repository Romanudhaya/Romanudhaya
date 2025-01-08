package com.uda1.storeprocedure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TransferMoney {
	private static final String DISP="select * from user";
	private static final String S_AMOUNT="update user set"+"Amount = Amount-? where accno=?";
	private static final String R_AMOUNT="update user set"+"Amount = Amount+? where accno=?";
	
	private static Connection con;
	private static String url = "jdbc:mysql://localhost:3306/firstjdbc";
	private static String username ="root";
	private static String password="udhaya6225@."; 
	private static Statement stmt;
	private static ResultSet res;
	private static Scanner sc=new Scanner(System.in);
	private static PreparedStatement pstmt; 
	static{
		
		try {
			// 1 Load the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2 Establish the connection
			con = DriverManager.getConnection(url, username, password);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		disp();
		try {
			con.setAutoCommit(false);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("Enter the SAccount: ");
		String s_Accno=sc.next();
		System.out.println("Enter the Amount: ");
		int Amount=sc.nextInt();
		try {
			pstmt = con.prepareStatement(S_AMOUNT);
			pstmt.setInt(1, Amount);
			pstmt.setString(2, s_Accno);
			int x=pstmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Enter the RAccount: ");
		String r_Accno=sc.next();
		try {
			pstmt = con.prepareStatement(R_AMOUNT);
			pstmt.setInt(1, Amount);
			pstmt.setString(2, r_Accno);
			int x=pstmt.executeUpdate();
			if(x==0) {
				System.out.println("failure");
			}
			else {
				System.out.println("Sucess");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		Authenticate.verify(sc,con);
		disp();
	}
	
	static void disp() {
		try {
			stmt = con.createStatement();
			res = stmt.executeQuery(DISP);
			
			while(res.next()) {
				System.out.println(res.getInt(1)+" "+res.getString(2)+" "+res.getString(3)+" "+res.getString(4));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
