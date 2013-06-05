package edu.iiitb.OnlineMovieTicketBooking.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import edu.iiitb.OnlineMovieTicketBooking.util.DB;

public class SellerRegistrationRequestDAO {

	public static int insert(SellerRegistrationRequest sellerRegistrationRequest) {
		String insertSQL = "insert into tSellerRegistrationRequest "

			+ "(sName ,sEmail ,sPassword ,sPhoneNumber ,sAddress  ) " +

			"values('" + sellerRegistrationRequest.getsName()+ "', '" +sellerRegistrationRequest.getsEmail() + "', " + sellerRegistrationRequest.getsPassword() + ", " + 
			sellerRegistrationRequest.getsPhoneNumber() + ", '" + sellerRegistrationRequest.getsAddress() +"');";
		return DB.update(insertSQL);
	}

	public static ArrayList<SellerRegistrationRequest> find(String selectionModifier) {
		ArrayList<SellerRegistrationRequest> selection = new ArrayList<SellerRegistrationRequest>();
		ResultSet resultSet = null;
		String query = "select iSellerID,sName,sEmail,sPassword,sPhoneNumber,sAddress from tSellerRegistrationRequest " + selectionModifier;
		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		try {
			while (resultSet.next()) {
				SellerRegistrationRequest sellerRegistrationRequest = getSellerRegistrationRequest(resultSet);
				selection.add(sellerRegistrationRequest);
			}
		} catch (SQLException e) {
			//  MyLog.myCatch("Book.java", 43, e);
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return selection;
	}

	private static SellerRegistrationRequest getSellerRegistrationRequest(ResultSet resultSet) {
		SellerRegistrationRequest sellerRegistrationRequest = new SellerRegistrationRequest();
		try {
			sellerRegistrationRequest.setiSellerID( resultSet.getInt("iSellerID") );
			sellerRegistrationRequest.setsName(resultSet.getString("sName"));
			sellerRegistrationRequest.setsEmail(resultSet.getString("sEmail"));
			sellerRegistrationRequest.setsPassword(resultSet.getString("sPassword"));
			sellerRegistrationRequest.setsPassword(resultSet.getString("sPhoneNumber"));
			sellerRegistrationRequest.setsPassword(resultSet.getString("sAddress"));

			return sellerRegistrationRequest;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sellerRegistrationRequest;
	}

	public static int DeleteOne(String selectionModifier){
		Statement stmt = null;
		//	ResultSet resultSet = null;
		String query = "delete from tSellerRegistrationRequest " + selectionModifier;
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



}
