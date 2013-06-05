package edu.iiitb.OnlineMovieTicketBooking.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.iiitb.OnlineMovieTicketBooking.util.DB;

public class TheatreClassAndPriceDAO {

	public static ArrayList<TheatreClassAndPrice> find(String selectionModifier) {
		// TODO Auto-generated method stub
		
		ArrayList<TheatreClassAndPrice> selection =new ArrayList<TheatreClassAndPrice>();
		ResultSet resultSet = null;
		String query = "select iTheaterClassID,sClass,iPrice,iNumberOfSeatsPerClass,iTheaterID " +
				" from tTheaterClassAndPrice "+selectionModifier;
		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		try {
			
			while (resultSet.next()) {
				TheatreClassAndPrice theatreClassAndPrice = getTheatreClassAndPriceFromResultSet(resultSet);
				selection.add(theatreClassAndPrice);
				}			
			
		} catch (SQLException e) {
         //  MyLog.myCatch("Book.java", 43, e);
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return selection;
	}
	public static TheatreClassAndPrice getTheatreClassAndPriceFromResultSet(ResultSet resultSet) {
		TheatreClassAndPrice theatreClassAndPrice =new TheatreClassAndPrice();;
	try {
		
		theatreClassAndPrice.setiTheatreClassID( resultSet.getInt("iTheaterClassID") );
		theatreClassAndPrice.setsClass( resultSet.getString("sClass") );
		theatreClassAndPrice.setiPrice( resultSet.getInt("iPrice") );
		theatreClassAndPrice.setiNimberOfSeatsPerClass( resultSet.getInt("iNumberOfSeatsPerClass") );
		theatreClassAndPrice.setiTheatreID( resultSet.getInt("iTheaterID") );
		
		
		return theatreClassAndPrice;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return theatreClassAndPrice;
	
	}
}
