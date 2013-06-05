package edu.iiitb.OnlineMovieTicketBooking.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.iiitb.OnlineMovieTicketBooking.util.DB;

public class reserveSeatService {
	
	
	public int getPriceOfTicket(int iMovieTimingID, int classType){
		
		String sql;
		int price;
		ResultSet rs=null;
	
		try {
			
			//ESTABLISH CONNECTION
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			java.sql.Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/jspproject?user=root&password=1234");
			java.sql.Statement statement = connection.createStatement();
			
			//SQL QUERY TO FIRE
			if( classType == 1 )
				sql="select iPriceOfType1  from  tmovietimings  where iMovieTimingID  = '"+iMovieTimingID+"';";
			else if ( classType == 2 )
				sql="select iPriceOfType2  from  tmovietimings  where iMovieTimingID  = '"+iMovieTimingID+"';";
			else
				sql="select iPriceOfType3  from  tmovietimings  where iMovieTimingID  = '"+iMovieTimingID+"';";
			
			rs=statement.executeQuery(sql);
			
			if(rs.next()){
				
				price =  rs.getInt(1);
				
				rs.close();
				if (statement != null) 
					statement.close();
				connection.close();
				
				return price;
			}
			else{
				
				rs.close();

				if (statement != null) 
					statement.close();
				connection.close();
				
				return -1;
			}
			
		} 
		catch (Exception e) {
			System.out.println(" Exception occurred in reserveSeatService.java	 exception:Exception" + e);
			return -2;
		} 
		
		
	}
	
	public int getBalance (int iSubscriberID){
		
		String sql;
		int balance;
		ResultSet rs=null;
	
		try {
			
			//ESTABLISH CONNECTION
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			java.sql.Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/jspproject?user=root&password=1234");
			java.sql.Statement statement = connection.createStatement();
			
			//SQL QUERY TO FIRE
			sql="select iBalance  from  tSignUpSubscriber  where iSubscriberID  = '"+iSubscriberID+"';";
			
			rs=statement.executeQuery(sql);
			
			if(rs.next()){
				
				balance =  rs.getInt(1);
				
				rs.close();
				if (statement != null) 
					statement.close();
				connection.close();
				
				return balance;
			}
			else{
				
				rs.close();

				if (statement != null) 
					statement.close();
				connection.close();
				
				return -1;
			}
			
		} 
		catch (Exception e) {
			System.out.println(" Exception occurred in reserveSeatService.java	 exception:Exception" + e);
			return -2;
		} 
		
		
	}
	
	public int getTotalSeatsLeft(int iMovieTimingID){
	
		String sql;
		int iTotalSeatsLeft;
		ResultSet rs=null;
	
		try {
			
			//ESTABLISH CONNECTION
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			java.sql.Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/jspproject?user=root&password=1234");
			java.sql.Statement statement = connection.createStatement();
			
			//SQL QUERY TO FIRE
			sql="select iSeatsLeft  from  tMovieTImings  where iMovieTimingID  = '"+iMovieTimingID+"';";
			
			rs=statement.executeQuery(sql);
			
			if(rs.next()){
				
				iTotalSeatsLeft =  rs.getInt(1);
				
				rs.close();
				if (statement != null) 
					statement.close();
				connection.close();
				
				return iTotalSeatsLeft;
			}
			else{
				
				rs.close();

				if (statement != null) 
					statement.close();
				connection.close();
				
				return -1;
			}
			
		} 
		catch (Exception e) {
			System.out.println(" Exception occurred in reserveSeatService.java	 exception:Exception" + e);
			return -2;
		} 
		
		
	}
	
	
}

	/*
	public String getClassFromDB(int sub){
		
		String classType="Gold";
		Connection con;
		Statement stmt;
		String query;
		ResultSet rs;
		
		
		try {
			
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con=DB.getConnection();
			stmt=con.createStatement();
			
			query="select sClass from tdummy where iSubscriberID="+"'"+sub+"';";
			System.out.println("The query -- > > . "+query);
			rs=stmt.executeQuery(query);
			
			while(rs.next()){
			 classType=rs.getString("sClass");
			}
			
			System.out.println("----> class" + classType);
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return classType;
		
	}
	*/

