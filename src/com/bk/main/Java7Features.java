package com.bk.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author BK
 * The purpose of this project is to give an overview of important features given by Java SE 7
 * 1. String literals in switch statements
 * 2. Diamond operator in Collection
 * 3. Handling multiple exceptions with a single catch block
 * 4. Try with resources block (ARM)
 */
public class Java7Features {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		
		/*1. String literals in switch statements
		 * Java 7 allows programmers to use String literals in switch statements*/
		String switchVal = "iPad";
		//Before Java SE 7
		if(switchVal.equalsIgnoreCase("Mobile"))
			System.out.println("if else Mobile came");
		else if(switchVal.equalsIgnoreCase("iPad"))
			System.out.println("if else iPad came");
		else if(switchVal.equalsIgnoreCase("Laptop"))
			System.out.println("if else Laptop came");
		else
			System.out.println("if else Nothing came");
		
		//After Java SE 7
		switch(switchVal){
			case "Mobile": System.out.println("switch Mobile came");
				break;
			case "iPad": System.out.println("switch iPad came");
				break;
			case "Laptop": System.out.println("switch Laptop came");
				break;
			default: System.out.println("switch Nothing came");
		}
		
		/*2. Diamond operator in Collection
		 * Generics are used to make collections type-safe. 
		 * Prior to Java SE 7, type information had to be supplied on both the sides of the statement which declares a collection. 
		 * But from Java SE 7, type information need not be repeated on the right hand side.*/
		
		//Before Java SE 7
		ArrayList<String> namesB4J7 = new ArrayList<String>();
		
		//After Java SE 7
		ArrayList<String> names = new ArrayList<>();
		
		/*3. Handling multiple exceptions with a single catch block
		 * A try block can be associated with multiple catch blocks to handle the various exceptions which may get raised from it. 
		 * Many a times, the exception handling logic is same for multiple catch blocks.
		 * From Java SE 7, a single catch block is sufficient to handle such multiple exceptions. 
		 * This reduces the duplication of code.*/
		
		//Before Java SE 7
		try {
		    // Code that may throw an exception
		}
		catch(NullPointerException ne) {
		    System.out.println(ne.getMessage());
		}
		catch(StringIndexOutOfBoundsException se) {
		    System.out.println(se.getMessage());
		}
		
		//After Java SE 7
		try {
		    // Code that may throw an exception
		}
		catch(NullPointerException | StringIndexOutOfBoundsException ex) {
		    System.out.println(ex.getMessage());
		}
		
		/*4. Try with resources block (ARM)
		 * Before Java SE 7, we used to close the non-Java resources such as streams and JDBC connections inside the finally block.
		 * To reduce coding and manage the resources efficiently, Java SE 7 has introduced a feature called the try-with-resources block, 
		 * where resources are opened at the beginning of the try block, and are closed automatically as the try block ends. 
		 * This feature can be termed as Automatic Resource Management (ARM).*/
		
		//Before Java SE 7
		Connection conn = null;
		try{
			conn = DriverManager.getConnection("url");
			// DB operations using connection
		}
		catch(SQLException e){
			System.err.println(e);
		}
		finally{
			if(conn != null)
				conn.close();
		}
		
		//After Java SE 7
		try(Connection con = DriverManager.getConnection("url")){
			// DB operations using connection
		}
		catch(SQLException se){
			System.err.println(se);
		}
		finally{
			//close is not required
		}
		
	}

}
