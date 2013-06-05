package edu.iiitb.OnlineMovieTicketBooking.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.iiitb.OnlineMovieTicketBooking.util.DB;
import edu.iiitb.OnlineMovieTicketBooking.util.MyLog;

public class TheatreDAO {
	

	public static int update(Theatre theatre) {
		String updateSQL = 
			    "update tTheater "
							+ 
				"set sName  = '" + theatre.getsName() + "' , sPhoneNumber  = '" + 
			    		theatre.getsPhoneNumber() + 
				"', sAddress  = " + theatre.getsAddress() + ", sCity  = " + 
			    		theatre.getsCity() + 
				", sState  = '" + 
				theatre.getsState()  + "' " + 
				
				", iNumberOfSeates   = '" + 
				theatre.getiNumberOfSeates()  + "'  where iTheaterID  = " + theatre.getiTheatreID();
		return DB.update(updateSQL);
	}

	public static int insert(Theatre theatre) {
		String insertSQL = "insert into tTheater "
			
				+ "(sName ,sPhoneNumber ,sAddress ,sCity ,sState ,iNumberOfSeates, iSellerID ) " +
				
				"values('" + theatre.getsName()+ "', '" + theatre.getsPhoneNumber() + "', " + theatre.getsAddress() + ", " + 
				theatre.getsCity() + ", '" + theatre.getsState() +"', " + theatre.getiNumberOfSeates()+"', " + theatre.getiSellerID()+"');";
		return DB.update(insertSQL);
	}

	public static ArrayList<Theatre> find(String selectionModifier) {
		ArrayList<Theatre> selection = new ArrayList<Theatre>();
		ResultSet resultSet = null;
		String query = "select iTheaterID ,sName ,sPhoneNumber ,sAddress ,sCity ,sState ,iNumberOfSeates, iSellerID  " +
				"from tTheater " + selectionModifier;
		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		try {
			while (resultSet.next()) {
				Theatre theatre = getTheatreFromResultSet(resultSet);
				selection.add(theatre);
			}
		} catch (SQLException e) {
            MyLog.myCatch("Book.java", 43, e);
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return selection;
	}
	public static Theatre getTheatreFromResultSet(ResultSet resultSet) {
	Theatre theatre = new Theatre();
	try {
		theatre.setiTheatreID( resultSet.getInt("iTheaterID") );
		theatre.setsName( resultSet.getString("sName") );
		theatre.setsPhoneNumber( resultSet.getString("sPhoneNumber") );
		theatre.setsAddress( resultSet.getString("sAddress") );
		theatre.setsCity( resultSet.getString("sCity") );
		theatre.setsState( resultSet.getString("sState") );
		theatre.setiNumberOfSeates ( resultSet.getInt("iNumberOfSeates") );
	theatre.setiSellerID( resultSet.getInt("iSellerID") );
	
	return theatre;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return theatre;
	
	}

	public static Theatre findOne(String selectionModifier) {
		ResultSet resultSet = null;
		
		String query = "select iTheaterID ,sName ,sPhoneNumber ,sAddress ,sCity ,sState ,iNumberOfSeates, iSellerID  " +
		"from tTheater " + selectionModifier;
		
		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		try {
			if (resultSet.next()) {
				Theatre theatre = getTheatreFromResultSet(resultSet);
				DB.close(resultSet);
				DB.close(connection);
				return theatre;
			}
		} catch (SQLException e) {
            MyLog.myCatch("Book.java", 43, e);
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return null;
	}



}
