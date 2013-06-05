package edu.iiitb.OnlineMovieTicketBooking.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;

import edu.iiitb.OnlineMovieTicketBooking.util.DB;

public class MoviesDAO {	

	public static ArrayList<Movies> find(String selectionModifier) {
		ArrayList<Movies> selection = new ArrayList<Movies>();
		ResultSet resultSet = null;
		String query = "select iMovieID,sName,iRating ,dScreeningStartDate ,dScreeningEndDate ,tShowTiming1 ,tShowTiming2,tShowTiming3,tShowTiming4,iTheaterID " +
				"from tMovies " + selectionModifier;
		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		try {
			while (resultSet.next()) {
				Movies movies = getMoviesFromResultSet(resultSet);
				selection.add(movies);
			}
		} catch (SQLException e) {
         //  MyLog.myCatch("Book.java", 43, e);
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return selection;
	}
	public static Movies getMoviesFromResultSet(ResultSet resultSet) {
	Movies movies = new Movies();
	try {
		movies.setImovieID( resultSet.getInt("iMovieID") );
		movies.setsName( resultSet.getString("sName") );
		movies.setiRating( resultSet.getInt("iRating") );
		movies.setdScreeningStartDate( resultSet.getDate("dScreeningStartDate") );
		movies.setdScreeningEndDate( resultSet.getDate("dScreeningEndDate") );
		movies.settShowTiming1( resultSet.getTime("tShowTiming1") );
		movies.settShowTiming2( resultSet.getTime("tShowTiming2") );
		movies.settShowTiming3( resultSet.getTime("tShowTiming3") );
		movies.settShowTiming4( resultSet.getTime("tShowTiming4") );
		movies.setiTheatreID( resultSet.getInt("iTheaterID") );
		
		return movies;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return movies;
	
	}

	
	
	public static Movies findOne(String selectionModifier) {

		
		
			ResultSet resultSet = null;
			
			String query = "select iMovieID ,sName ,iRating ,dScreeningStartDate ,dScreeningEndDate,tShowTiming1,tShowTiming2,tShowTiming3,tShowTiming4,iTheaterID " +
			" from tMovies " + selectionModifier;
			
			Connection connection = DB.getConnection();
			resultSet = DB.readFromDB(query, connection);
			Movies movie=null;
			try {
				if (resultSet.next()) {
					 movie= new Movies();
					 movie.setImovieID(resultSet.getInt(1));
					 movie.setsName(resultSet.getString(2));
					DB.close(resultSet);
					DB.close(connection);
					return movie;
				}
			} catch (SQLException e) {
	           // MyLog.myCatch("Book.java", 43, e);
				e.printStackTrace();
			}
			DB.close(resultSet);
			DB.close(connection);
			return null;
		}
	
public static int insert(Movies movies) {
		
		
		return 0;
	}

	public static int DeleteOne(String selectionModifier) {
		
		Statement stmt = null;
	//	ResultSet resultSet = null;
		String query = "delete from tmovies " + selectionModifier;
	//	PreparedStatement ps;
		Connection connection = DB.getConnection();
		System.out.println(selectionModifier);
		try {
			System.out.println("I am in movies delete");
			stmt=connection.createStatement();
			stmt.executeUpdate(query);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			DB.close(connection);
		return 1;
	}
	public static int update(Movies movies) {
		/*String updateSQL = 
	    "update tMovies "
					+ 
		"set sName  = '" + movies.getsName() + "' , sPhoneNumber  = '" + 
	    		movies.getsPhoneNumber() + 
		"', sAddress  = " + movies.getsAddress() + ", sCity  = " + 
	    		movies.getsCity() + 
		", sState  = '" + 
		movies.getsState()  + "' " + 
		
		", iNumberOfSeates   = '" + 
		movies.getiNumberOfSeates()  + "'  where iMoviesID  = " + movies.getiMoviesID();
return DB.update(updateSQL);
}

public static int insert(Movies movies) {
String insertSQL = "insert into tMovies "
	
		+ "(sName ,sPhoneNumber ,sAddress ,sCity ,sState ,iNumberOfSeates, iSellerID ) " +
		
		"values('" + movies.getsName()+ "', '" + movies.getsPhoneNumber() + "', " + movies.getsAddress() + ", " + 
		movies.getsCity() + ", '" + movies.getsState() +"', " + movies.getiNumberOfSeates()+"', " + movies.getiSellerID()+"');";
return DB.update(insertSQL);*/
		// TODO Auto-generated method stub
		return 0;
	}

}
