package edu.iiitb.OnlineMovieTicketBooking.service;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class cancelTicketService {

	
	public int fetchDetails(int iTicketID){
		
		String sql;
		ResultSet rs=null;
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		
		try {

			//ESTABLISH CONNECTION
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			java.sql.Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/jspproject?user=root&password=1234");
			java.sql.Statement statement = connection.createStatement();

			//SQL QUERY TO FIRE (UPDATE QUERY)
			sql = " select * from tTicket where iTicketID ="+iTicketID+";";
			
			rs = statement.executeQuery(sql);

			if(rs.next()){
				
				session.put("canceliAmount", rs.getInt(2));
				session.put("canceliNumberOfTicketsBought", rs.getInt(3));
				session.put("cancelsSeatNumber", rs.getString(4));
				session.put("cancelsClass", rs.getString(5));
				
				rs.close();
				
				if (statement != null) 
					statement.close();

				connection.close();

				return 1;
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
			System.out.println(" Exception occurred in cancelTicketService.java	 exception:Exception" + e);
			return -2;
		} 
		
	}
	
	
	public int fetchDetailsFromtMovieTimings(int iMovieTimingID, String sClass){
		
		String sql;
		ResultSet rs=null;
		int iTypeOfSeat;
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		
		try {

			//ESTABLISH CONNECTION
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			java.sql.Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/jspproject?user=root&password=1234");
			java.sql.Statement statement = connection.createStatement();

			//SQL QUERY TO FIRE (UPDATE QUERY)
			sql = " select * from tMovieTimings where iMovieTimingID ="+iMovieTimingID+";";
			
			if( sClass.equalsIgnoreCase("Gold") )
				iTypeOfSeat = 1;
			else if ( sClass.equalsIgnoreCase("Silver") )
				iTypeOfSeat = 2;
			else 
				iTypeOfSeat = 3;
			
			
			rs = statement.executeQuery(sql);

			if(rs.next()){
				
				session.put("updateiSeatsLeft", rs.getInt(4));
				
				if(iTypeOfSeat == 1){
					session.put("updateiSeatsLeftType", rs.getInt(8));
					String str=rs.getString(9);
					session.put("updatesSeatsLeftOfType", str);
				}
				else if ( iTypeOfSeat == 2 ){
					String str=rs.getString(12);
					session.put("updateiSeatsLeftType", rs.getInt(11));
					session.put("updatesSeatsLeftOfType", str);
				}
				else {
					session.put("updateiSeatsLeftType", rs.getInt(14));	
					session.put("updatesSeatsLeftOfType", rs.getString(15));
				}
				
				rs.close();
				
				if (statement != null) 
					statement.close();

				connection.close();

				return 1;
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
			System.out.println(" Exception occurred in cancelTicketService.java	 exception:Exception" + e);
			return -2;
		} 
		
	}
	
	
	public int updateDetailsIntMovieTimings(int updatediSeatsLeft, int updatediSeatsLeftType, String updatedsSeatsLeftOfType, String cancelsClass, int iMovieTimingID){
		
		String sql;
		int iTypeOfSeat;
		
		try {

			//ESTABLISH CONNECTION
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			java.sql.Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/jspproject?user=root&password=1234");
			java.sql.Statement statement = connection.createStatement();

			if( cancelsClass.equalsIgnoreCase("Gold") )
				iTypeOfSeat = 1;
			else if ( cancelsClass.equalsIgnoreCase("Silver") )
				iTypeOfSeat = 2;
			else 
				iTypeOfSeat = 3;
			
			//SQL QUERY TO FIRE (UPDATE QUERY)
			if(iTypeOfSeat == 1)
				sql = "UPDATE tMovieTimings SET iSeatsLeft = '"+updatediSeatsLeft+"', iSeatsLeftType1 ='"+updatediSeatsLeftType+"', sSeatsLeftOfType1 ='"+updatedsSeatsLeftOfType+"' WHERE iMovieTimingID ='"+iMovieTimingID+"' ;";
			else if (iTypeOfSeat == 2)
				sql = "UPDATE tMovieTimings SET iSeatsLeft = '"+updatediSeatsLeft+"', iSeatsLeftType2 ='"+updatediSeatsLeftType+"', sSeatsLeftOfType2 ='"+updatedsSeatsLeftOfType+"' WHERE iMovieTimingID ='"+iMovieTimingID+"' ;";
			else
				sql = "UPDATE tMovieTimings SET iSeatsLeft = '"+updatediSeatsLeft+"', iSeatsLeftType3 ='"+updatediSeatsLeftType+"', sSeatsLeftOfType3 ='"+updatedsSeatsLeftOfType+"' WHERE iMovieTimingID ='"+iMovieTimingID+"' ;";

			statement.executeUpdate(sql);

			if (statement != null) 
				statement.close();

			connection.close();

			//SUCCESSFUL EXECUTION OF UPDATE QUERY
			return 1;

		}

		catch (Exception e) {
			System.out.println(" Exception occurred in cancelTicketService.java	 exception:Exception" + e);
			return -2;
		} 
		
	}
	
	
	public int updatesPaidStatus (int iTicketID){
		
		String sql;
		
		try {

			//ESTABLISH CONNECTION
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			java.sql.Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/jspproject?user=root&password=1234");
			java.sql.Statement statement = connection.createStatement();

			//SQL QUERY TO FIRE (UPDATE QUERY)
			sql = "UPDATE tTicket SET sPaidStatus = 'cancelled' WHERE iTicketID ='"+iTicketID+"' ;";

			statement.executeUpdate(sql);

			if (statement != null) 
				statement.close();

			connection.close();

			//SUCCESSFUL EXECUTION OF UPDATE QUERY
			return 1;

		}

		catch (Exception e) {
			System.out.println(" Exception occurred in cancelTicketService.java	 exception:Exception" + e);
			return -2;
		} 
	}
	
	
}
