package edu.iiitb.OnlineMovieTicketBooking.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.iiitb.OnlineMovieTicketBooking.util.DB;


public class AdminDAO {

	public static Admin findOne(String selectionModifier) {

		ResultSet resultSet = null;
		
		String query = "select iAdminID  ,sAdminName  ,sAdminEmail ,sAdminPassword ,sAdminPhoneNumber ,sAdminAddress " +
		" from tAdmin " + selectionModifier;
		
		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		try {
			if (resultSet.next()) {
				Admin admin_candidate = getAdminFromResultSet(resultSet);
				DB.close(resultSet);
				DB.close(connection);
				return admin_candidate;
			}
		} catch (SQLException e) {
          //  MyLog.myCatch("Book.java", 43, e);
			//e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return null;
	}

	private static Admin getAdminFromResultSet(ResultSet resultSet) {
		
		Admin admin_candidate = new Admin();
			try {
				admin_candidate.setAdminID( resultSet.getInt("iAdminID")) ;
				admin_candidate.setsAdminAddress(resultSet.getString("sAdminAddress")) ;
				admin_candidate.setsAdminEmail(resultSet.getString("sAdminEmail"));
				admin_candidate.setsAdminName(resultSet.getString("sAdminName"));
				admin_candidate.setsAdminPassword(resultSet.getString("sAdminPassword"));
				admin_candidate.setsAdminPhoneNumber(resultSet.getString("sAdminPhoneNumber"));
				
			
			
			return admin_candidate;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return admin_candidate;
			
			}

	
		
		public static int update(String  selectionModifier) {

			String updateSQL = "update tSignUpSeller " + selectionModifier ;
			return DB.update(updateSQL);
		
	}
	
	

}


