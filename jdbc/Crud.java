package com.uda1.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.uda1.jdbc.Firstjdbc;

public class Crud {
	 static Connection con;
	 static PreparedStatement pstmt;
	 /* static String sql="update `student` set `stud_name`= ? where `stud_id`= ?";
		public static void main(String[] args) {
		 	try {
		 		Scanner sc = new Scanner(System.in);
				System.out.println("Enter the studname: ");
		        String stud_name=sc.nextLine();		
		        System.out.println("Enter the id: ");
		        int stud_id=sc.nextInt();
		        
		        con = Firstjdbc.connect();
		        pstmt = con.prepareStatement(sql);
		        pstmt.setString(1, stud_name);
		        pstmt.setInt(2, stud_id);
		        int x=pstmt.executeUpdate();
		        System.out.println(x + "rows updated...");
		        
		 	}*/
	 static String sql="delete from student where stud_id=?";
	 public static void main(String[] args) {
		 try {
			 Scanner sc = new Scanner(System.in);
			 System.out.println("Enter the id: ");
		     int stud_id=sc.nextInt();
		     con = Firstjdbc.connect();
		     pstmt = con.prepareStatement(sql);
		     pstmt.setInt(1, stud_id);
		     
		     int x=pstmt.executeUpdate();
		     System.out.println(x +"row deleted...");
		 }
		 
	 	catch(Exception e) {
	 		e.printStackTrace();
	 	}
		 

	}

}
