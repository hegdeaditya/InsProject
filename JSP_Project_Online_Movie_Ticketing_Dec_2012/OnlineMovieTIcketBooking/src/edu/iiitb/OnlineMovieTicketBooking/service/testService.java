package edu.iiitb.OnlineMovieTicketBooking.service;

import java.sql.DriverManager;
import java.sql.ResultSet;

public class testService {

	public String getSeatsAvailable(int iMovieTimingID, int classType){
		
		//CLASS TYPE
		//1: Gold
		//2. Silver
		//3. Economy
		
		String seatsAvailable;
		String sql;
		
		ResultSet rs=null;
		
		try {
			
			//ESTABLISH CONNECTION
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			java.sql.Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/jspproject?user=root&password=1234");
			java.sql.Statement statement = connection.createStatement();
			
			//SQL QUERY TO FIRE
			if( classType == 1 )
				sql="select distinct sSeatsLeftOfType1  from  tmovietimings  where iMovieTimingID  = '"+iMovieTimingID+"';";
			else if ( classType == 2 )
				sql="select distinct sSeatsLeftOfType2  from  tmovietimings  where iMovieTimingID  = '"+iMovieTimingID+"';";
			else
				sql="select distinct sSeatsLeftOfType3  from  tmovietimings  where iMovieTimingID  = '"+iMovieTimingID+"';";
			
			rs=statement.executeQuery(sql);
			
			if(rs.next()){
				
				seatsAvailable = rs.getString(1);
				
				rs.close();
				if (statement != null) 
					statement.close();
				connection.close();
				
				return seatsAvailable;
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
			System.out.println(" Exception occurred in testService.java	 exception:Exception" + e);
			return null;
		} 
		
	}
}
