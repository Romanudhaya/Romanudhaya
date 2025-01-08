package com.uda1.storeprocedure;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Authenticate {
	private static int pin=121212;
	public static void verify(Scanner scan,Connection con) {
	     System.out.println("send the money enter the pin: ");
	     int upin=scan.nextInt();
	     if(upin == pin) {
	    	 try {
	    		 con.commit();
	    	 }
	    	 catch(SQLException e) {
	    		 e.printStackTrace();
	    	 }
	     }
		
	}

}
