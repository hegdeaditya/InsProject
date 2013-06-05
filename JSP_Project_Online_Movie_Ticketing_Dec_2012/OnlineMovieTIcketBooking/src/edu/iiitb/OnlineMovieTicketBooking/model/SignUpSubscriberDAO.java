package edu.iiitb.OnlineMovieTicketBooking.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.iiitb.OnlineMovieTicketBooking.util.DB;

public class SignUpSubscriberDAO {

	
	
	
	

	public static int update(String  selectionModifier) {

		String updateSQL = "update tSignUpSubscriber " + selectionModifier ;
		return DB.update(updateSQL);
	}
	
	public static ArrayList<SignUpSubscriber> find(String selectionModifier) {
		
		
		ArrayList<SignUpSubscriber> selection = new ArrayList<SignUpSubscriber>();
		ResultSet resultSet = null;
		String query = "select iSubscriberID,sName,sEmail,sPassword,sPhoneNumber,sAddress,iDOB,iBalance,iRegistrationStatus from tSignUpSubscriber " + selectionModifier;
		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		try {
			while (resultSet.next()) {
				SignUpSubscriber signUpSubscriber = getSignUpSubscriber(resultSet);
				selection.add(signUpSubscriber);
			}
		} catch (SQLException e) {
         //  MyLog.myCatch("Book.java", 43, e);
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return selection;
	}

	private static SignUpSubscriber getSignUpSubscriber(ResultSet resultSet) {
		SignUpSubscriber signUpSubscriber = new SignUpSubscriber();
		try {
			signUpSubscriber.setiSubscriberID( resultSet.getInt("iSubscriberID") );
			signUpSubscriber.setsName(resultSet.getString("sName"));
			signUpSubscriber.setsEmail(resultSet.getString("sEmail"));
			signUpSubscriber.setsPassword(resultSet.getString("sPassword"));
			signUpSubscriber.setsAddress(resultSet.getString("sPhoneNumber"));
			signUpSubscriber.setsPhoneNumber(resultSet.getString("sAddress"));
			signUpSubscriber.setiDOB(resultSet.getDate("iDOB"));
			signUpSubscriber.setiBalance(resultSet.getInt("iBalance"));
			signUpSubscriber.setiRegistrationStatus(resultSet.getInt("iRegistrationStatus"));
			return signUpSubscriber;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return signUpSubscriber;
	}

	public static int insert(SignUpSubscriber signUpSubscriber) {
		String url = "jdbc:mysql://localhost:3306/jspproject";
		int ret=0;
		ResultSet rs=null;
		try {
			String insert = "INSERT INTO tsignupsubscriber(sName,sEmail,sPassword,sPhoneNumber,sAddress,iDOB,iBalance,iRegistrationStatus)" +
			"VALUES (?, ?, ?, ?, ?, ?, ?,?)";
			//System.out.println(session.get("RegisterSeller"));
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "root", "1234");

			PreparedStatement ps = con.prepareStatement(insert);

			ps.setString(1,signUpSubscriber.getsName());
			ps.setString(2,signUpSubscriber.getsEmail());
			ps.setString(3,signUpSubscriber.getsPassword());
			ps.setString(4,signUpSubscriber.getsPhoneNumber());
			ps.setString(5,signUpSubscriber.getsAddress());
			ps.setDate(6,signUpSubscriber.getiDOB());
			ps.setInt(7,signUpSubscriber.getiBalance());
			int iRegStatus=1;
			ps.setInt(8,iRegStatus);
			
			
			ret=ps.executeUpdate();
			con.close();


		} catch (Exception ex) {
		
			ex.printStackTrace();

		}
		return ret;
	}

}



