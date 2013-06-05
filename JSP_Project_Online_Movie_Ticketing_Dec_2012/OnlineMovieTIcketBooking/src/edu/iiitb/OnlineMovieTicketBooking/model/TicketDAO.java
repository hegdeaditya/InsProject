package edu.iiitb.OnlineMovieTicketBooking.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.iiitb.OnlineMovieTicketBooking.util.DB;
import edu.iiitb.OnlineMovieTicketBooking.util.MyLog;

public class TicketDAO {
	public static ArrayList<Ticket> find(String selectionModifier) {
		ArrayList<Ticket> selection = new ArrayList<Ticket>();
		ResultSet resultSet = null;
		String query = "select iTicketID , iAmountPaid, iNumberOfTicketsBought, sClass, sSeatNumber, dDate, sTime, iMovieTimingID " +
				"from tTicket " + selectionModifier;
		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		try {
			while (resultSet.next()) {
				Ticket ticket = getTicketFromResultSet(resultSet);
				selection.add(ticket);
			}
		} catch (SQLException e) {
            MyLog.myCatch("Book.java", 43, e);
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return selection;
	}
	
	
	public static Ticket getTicketFromResultSet(ResultSet resultSet) {
	Ticket ticket = new Ticket();
	try {
		ticket.setiTicketID( resultSet.getInt("iTicketID") );
		ticket.setiAmountPaid( resultSet.getInt("iAmountPaid") );
		ticket.setiNumberOfTicketsBought( resultSet.getInt("iNumberOfTicketsBought") );
		ticket.setsClass(resultSet.getString("sClass"));
		ticket.setsSeatNumber( resultSet.getString("sSeatNumber") );
		ticket.setdDate( resultSet.getDate("dDate") );
		ticket.setsTime( resultSet.getString("sTime") );
		ticket.setiMovieTimingID ( resultSet.getInt("iMovieTimingID") );
	
	return ticket;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return ticket;
	
	}
}
