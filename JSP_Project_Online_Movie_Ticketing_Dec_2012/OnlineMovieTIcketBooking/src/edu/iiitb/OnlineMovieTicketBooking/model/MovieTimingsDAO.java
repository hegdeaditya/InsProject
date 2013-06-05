package edu.iiitb.OnlineMovieTicketBooking.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import edu.iiitb.OnlineMovieTicketBooking.util.DB;
import edu.iiitb.OnlineMovieTicketBooking.util.MyLog;

public class MovieTimingsDAO {

	public static int insert(MovieTimings movieTimings) {
		// TODO Auto-generated method stub
		
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			java.sql.Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/jspproject?user=root&password=1234");
			java.sql.Statement statement = connection.createStatement();
			
			String sql1="insert into tMovieTimings(dDate,tTime,iSeatsLeft,sClass1,sClass2,sClass3,iSeatsLeftType1,sSeatsLeftOfType1,iPriceOfType1,iSeatsLeftType2 ,sSeatsLeftOfType2,iPriceOfType2,iSeatsLeftType3,sSeatsLeftOfType3 ,iPriceOfType3,iMovieID ) " +
					"values('"+movieTimings.getdDate()+"','"+movieTimings.gettTime()+"',"+movieTimings.getiSeatsLeft()+",'"+movieTimings.getsClass1()+"','"+movieTimings.getsClass2()+"','"+movieTimings.getsClass3()+"',"+movieTimings.getiSeatsLeftType1()+",'"+movieTimings.getsSeatsLeftOfType1()+"',"+movieTimings.getiPriceOfType1()+","+movieTimings.getiSeatsLeftType2()+",'"+movieTimings.getsSeatsLeftOfType2()+"',"+movieTimings.getiPriceOfType2()+","+movieTimings.getiSeatsLeftType3()+",'"+movieTimings.getsSeatsLeftOfType3()+"',"+movieTimings.getiPriceOfType3()+","+movieTimings.getiMovieID()+");"; 
					
			String sql="insert into tMovieTimings(dDate,tTime,iSeatsLeft,sClass1,sClass2,sClass3,iSeatsLeftType1,sSeatsLeftOfType1,iPriceOfType1,iSeatsLeftType2 ,sSeatsLeftOfType2,iPriceOfType2,iSeatsLeftType3,sSeatsLeftOfType3 ,iPriceOfType3,iMovieID ) " +
			"values('"+movieTimings.getdDate()+"','"+
			movieTimings.gettTime()+"',"+
			movieTimings.getiSeatsLeft()+",'"+
			movieTimings.getsClass1()+"','"+
			movieTimings.getsClass2()+"','"+
			movieTimings.getsClass3()+"',"+
			movieTimings.getiSeatsLeftType1()+",'"+
			movieTimings.getsSeatsLeftOfType1()+"',"+
			movieTimings.getiPriceOfType1()+","+
			movieTimings.getiSeatsLeftType2()+",'"+
			movieTimings.getsSeatsLeftOfType2()+"',"+
			movieTimings.getiPriceOfType2()+","+
			movieTimings.getiSeatsLeftType3()+",'"+
			movieTimings.getsSeatsLeftOfType3()+"',"
			+movieTimings.getiPriceOfType3()+","+
			movieTimings.getiMovieID()+");"; 
	
			int autoIncKeyFromApi = -1;
			statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
			rs=statement.getGeneratedKeys();
			if(rs.next()){
				autoIncKeyFromApi=rs.getInt(1);
			}else{
				throw new Exception("key not generated!");
			}
			rs.close();
//			System.out.println("id="+autoIncKeyFromApi);
			if (statement != null) 
				statement.close();
			connection.close();
			//returns the patient id
			return autoIncKeyFromApi;
			
		} catch (Exception e) {
			System.out.println(" Exception occurred	exception:Exception" + e);
			return 0;
		}
		
		
	}

	public static ArrayList<MovieTimings> findForOverlappingOfMovieTimings(String selectionModifier) {
		ArrayList<MovieTimings> selection = new ArrayList<MovieTimings>();
		ResultSet resultSet = null;
		String query = "select tm.iMovieTimingID from tMovieTimings tm , tmovies t " + selectionModifier;
		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		try {
			while (resultSet.next()) {
				MovieTimings movietimings = getMovieTimings(resultSet);
				selection.add(movietimings);
			}
		} catch (SQLException e) {
         //  MyLog.myCatch("Book.java", 43, e);
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return selection;
	}

	private static MovieTimings getMovieTimings(ResultSet resultSet) {
		MovieTimings movieTimings = new MovieTimings();
		try {
			movieTimings.setiMovieTimingID( resultSet.getInt("tm.iMovieTimingID") );
			
			
			return movieTimings;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return movieTimings;
	}

	
	
	public static MovieTimings findOne(String selectionModifier) {
		ResultSet resultSet = null;
		
		String query = "select iMovieTimingID, dDate,tTime,iSeatsLeft,sClass1,sClass2,sClass3,iSeatsLeftType1,sSeatsLeftOfType1,iPriceOfType1,iSeatsLeftType2 ,sSeatsLeftOfType2,iPriceOfType2,iSeatsLeftType3,sSeatsLeftOfType3 ,iPriceOfType3,iMovieID   " +
		" from tMovieTimings " + selectionModifier;
		
		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		try {
			if (resultSet.next()) {
				MovieTimings movieTimings  = getMovieTimingsFromResultSet(resultSet);
				DB.close(resultSet);
				DB.close(connection);
				return movieTimings;
			}
		} catch (SQLException e) {
            MyLog.myCatch("Book.java", 43, e);
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return null;
	}
	public static MovieTimings getMovieTimingsFromResultSet(ResultSet resultSet) {
		MovieTimings movieTimings = new MovieTimings();
		try {
			movieTimings.setiMovieTimingID(resultSet.getInt(1));
			//neeed to set other things when needed
		
		return movieTimings;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return movieTimings;
		
	}
	
}
