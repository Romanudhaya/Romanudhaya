package com.uda1.specific;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.uda1.jdbc.Firstjdbc;
 
public class FetchSpecific {
	private static String sql = "Select * from student where stud_id=?";
    static Connection con;
    static PreparedStatement pstmt;
    static ResultSet res;
	public static void main(String[] args) {
		try {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the studentid: ");
			int studId=sc.nextInt();
			//1,2
			con = Firstjdbc.connect();
			// createStmt
			 pstmt = con.prepareStatement(sql);
			 pstmt.setInt(1, studId);
			 res = pstmt.executeQuery();
			 
			 if(res.next()) {
				 System.out.println(res.getInt(1)+" "+
			             res.getString(2)+" "+
						res.getString(3)+" "+
			             res.getString(4)+" "+
						res.getString(5)
			             );
			 }
			 else {
				 System.out.println("No records found");
			 }
			 
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
