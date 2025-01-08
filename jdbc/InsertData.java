package com.uda1.insert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.uda1.jdbc.Firstjdbc;

public class InsertData {
		private static String sql = "Insert into student(stud_name,email,mobile,course_name,stud_id)" +"values(?,?,?,?,?)";
	    static Connection con;
	    static PreparedStatement pstmt;
	    static ResultSet res;
		public static void main(String[] args) {
			try {
				Scanner sc=new Scanner(System.in);
			    System.out.println("Enter the studentname: ");
			    String Stud_name=sc.nextLine();
				System.out.println("Enter the email: ");
				String email=sc.nextLine();
				System.out.println("Enter the mobile: ");
				String mobile=sc.nextLine();
				System.out.println("Enter the course_name: ");
				String course_name=sc.nextLine();
				System.out.println("Enter the studentid: ");
				int studId=sc.nextInt(); 
				//1,2
				con = Firstjdbc.connect();
				// createStmt
				 pstmt = con.prepareStatement(sql);
				 
				 pstmt.setString(1, Stud_name);
				 pstmt.setString(2, email);
				 pstmt.setString(3, mobile);
				 pstmt.setString(4, course_name);
				 pstmt.setInt(5, studId);
				 int x=pstmt.executeUpdate();
				 System.out.println(x +"rows Inserted...");
			}
			catch(Exception e) {
				e.printStackTrace();
			}

	}

}
