package edu.iiitb.OnlineMovieTicketBooking.service;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Time;

public class bookingSummaryService {

	public int updateTableTMovieTimings(int iMovieTimingID, int iUpdateTotalSeats, int iUpdateNumberOfSeatsLeft, String sUpdateSeatsLeft, int iClassType){

		String sql;

		try {

			//ESTABLISH CONNECTION
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			java.sql.Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/jspproject?user=root&password=1234");
			java.sql.Statement statement = connection.createStatement();

			//SQL QUERY TO FIRE (UPDATE QUERY)
			if(iClassType == 1)
				sql = "UPDATE tMovieTimings SET iSeatsLeft = '"+iUpdateTotalSeats+"', iSeatsLeftType1 ='"+iUpdateNumberOfSeatsLeft+"', sSeatsLeftOfType1 ='"+sUpdateSeatsLeft+"' WHERE iMovieTimingID ="+iMovieTimingID+" ;";
			else if (iClassType == 2)
				sql = "UPDATE tMovieTimings SET iSeatsLeft = '"+iUpdateTotalSeats+"', iSeatsLeftType2 ='"+iUpdateNumberOfSeatsLeft+"', sSeatsLeftOfType2 ='"+sUpdateSeatsLeft+"' WHERE iMovieTimingID ="+iMovieTimingID+" ;";
			else
				sql = "UPDATE tMovieTimings SET iSeatsLeft = '"+iUpdateTotalSeats+"', iSeatsLeftType3 ='"+iUpdateNumberOfSeatsLeft+"', sSeatsLeftOfType3 ='"+sUpdateSeatsLeft+"' WHERE iMovieTimingID ="+iMovieTimingID+" ;";

			statement.executeUpdate(sql);

			if (statement != null) 
				statement.close();

			connection.close();

			//SUCCESSFUL EXECUTION OF UPDATE QUERY
			return 1;

		}

		catch (Exception e) {
			System.out.println(" Exception occurred in bookingSummaryService.java	 exception:Exception" + e);
			return -2;
		} 
	}

	public int insertIntoTableTTicket(int iAmountPaid, int iNumberOfTicketsBought, String sSeatNumber, String sClass, java.sql.Date dDate, String sTime, String sPaidStatus, int iSubscriberID, int iMovieTimingID){

		String sql;

		try {

			//ESTABLISH CONNECTION
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			java.sql.Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/jspproject?user=root&password=1234");
			java.sql.Statement statement = connection.createStatement();

			//SQL QUERY TO FIRE (INSERT QUERY)
			sql = "INSERT INTO tTicket (iAmountPaid, iNumberOfTicketsBought, sSeatNumber, sClass, dDate, sTime, sPaidStatus, iSubscriberID, iMovieTimingID) VALUES ("+iAmountPaid+", "+iNumberOfTicketsBought+", '"+sSeatNumber+"', '"+sClass+"', '"+dDate+"', '"+sTime+"', '"+sPaidStatus+"', "+iSubscriberID+", "+iMovieTimingID+");";

			statement.executeUpdate(sql);

			if (statement != null) 
				statement.close();
			
			connection.close();

			return 1;
		} 
		catch (Exception e) {
			System.out.println(" Exception occurred in bookingSummaryService.java	 exception:Exception" + e);
			return -1;
		} 

	}
	
	public int updateBalance (int iSubscriberID, int iBalance){
		
		String sql;

		try {

			//ESTABLISH CONNECTION
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			java.sql.Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/jspproject?user=root&password=1234");
			java.sql.Statement statement = connection.createStatement();

			//SQL QUERY TO FIRE (INSERT QUERY)
			sql = "UPDATE tSignUpSubscriber SET iBalance = '"+iBalance+"' WHERE iSubscriberID = '"+iSubscriberID+"' ;";
			
			statement.executeUpdate(sql);

			if (statement != null) 
				statement.close();
			
			connection.close();

			return 1;
		} 
		catch (Exception e) {
			System.out.println(" Exception occurred in updating Balance bookingSummaryService.java	 exception:Exception" + e);
			return -1;
		} 
	}
	
	public String getEmailOfSubscriber (int iSubscriberID){
		
		String sql;
		String email;
		ResultSet rs=null;
	
		try {
			
			//ESTABLISH CONNECTION
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			java.sql.Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/jspproject?user=root&password=1234");
			java.sql.Statement statement = connection.createStatement();
			
			//SQL QUERY TO FIRE
			sql="select sEmail  from  tSignUpSubscriber  where iSubscriberID  = '"+iSubscriberID+"';";
			
			rs=statement.executeQuery(sql);
			
			if(rs.next()){
				
				email =  rs.getString(1);
				
				rs.close();
				if (statement != null) 
					statement.close();
				connection.close();
				
				return email;
			}
			else{
				
				rs.close();

				if (statement != null) 
					statement.close();
				connection.close();
				
				return null;
			}
			
		} 
		catch (Exception e) {
			System.out.println(" Exception occurred in reserveSeatService.java	 exception:Exception" + e);
			return null;
		} 
		
	}
	
	public int getTicketID (){
		String sql;
		int iTicketID;
		ResultSet rs=null;
	
		try {
			
			//ESTABLISH CONNECTION
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			java.sql.Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/jspproject?user=root&password=1234");
			java.sql.Statement statement = connection.createStatement();
			
			//SQL QUERY TO FIRE
			sql="select iTicketID  from  tTicket  ORDER BY iTicketID DESC LIMIT 1;";
			
			rs=statement.executeQuery(sql);
			
			if(rs.next()){
				
				iTicketID =  rs.getInt(1);
				
				rs.close();
				if (statement != null) 
					statement.close();
				connection.close();
				
				return iTicketID;
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
	
	public String getTicketDetails(int iTicketID){
		
		String sql;
		String ticketDetailDate;
		String ticketDetailTime;
		String ticketDetails;
		ResultSet rs=null;
	
		try {
			
			//ESTABLISH CONNECTION
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			java.sql.Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/jspproject?user=root&password=1234");
			java.sql.Statement statement = connection.createStatement();
			
			//SQL QUERY TO FIRE
			sql="select sDate, sTime  from  tTicket  WHERE iTicketID = "+iTicketID+";";
			
			rs=statement.executeQuery(sql);
			
			if(rs.next()){
				
				ticketDetailDate =  rs.getString(1);
				ticketDetailTime = rs.getString(2);
				
				ticketDetails = ticketDetailDate + ticketDetailTime;
				
				rs.close();
				if (statement != null) 
					statement.close();
				connection.close();
				
				return ticketDetails;
			}
			else{
				
				rs.close();

				if (statement != null) 
					statement.close();
				connection.close();
				
				return null;
			}
			
		} 
		catch (Exception e) {
			System.out.println(" Exception occurred in reserveSeatService.java	 exception:Exception" + e);
			return null;
		} 
		
	}
	
}

