package edu.iiitb.OnlineMovieTicketBooking.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import edu.iiitb.OnlineMovieTicketBooking.util.DB;

public class SignUpSellerDAO {

	public static int insert(SignUpSeller signUpSeller) {

		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			java.sql.Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/jspproject?user=root&password=1234");
			java.sql.Statement statement = connection.createStatement();

			String sql="insert into tSignUpSeller(sName,sEmail,sPassword,sPhoneNumber,sAddress,iRegistrationStatus) " +
			"values('"+signUpSeller.getsName()+"','"+signUpSeller.getsEmail()+"','"+signUpSeller.getsPassword()+"','"+signUpSeller.getsPhoneNumber()+"','"+signUpSeller.getsAddress()+"',"+signUpSeller.getiRegistrationStatus()+");"; 


			int autoIncKeyFromApi = -1;
			statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
			rs=statement.getGeneratedKeys();
			if(rs.next()){
				autoIncKeyFromApi=rs.getInt(1);
			}else{
				throw new Exception("key not generated!");
			}
			rs.close();

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

	public static ArrayList<SignUpSeller> find(String selectionModifier) {
		ArrayList<SignUpSeller> selection = new ArrayList<SignUpSeller>();
		ResultSet resultSet = null;
		String query = "select iSellerID,sName,sEmail,sPassword,sPhoneNumber,sAddress,iRegistrationStatus  from tSignUpSeller " + selectionModifier;
		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		try {
			while (resultSet.next()) {
				SignUpSeller signUpSeller = getSignUpSeller(resultSet);
				selection.add(signUpSeller);
			}
		} catch (SQLException e) {
			//  MyLog.myCatch("Book.java", 43, e);
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return selection;
	}

	private static SignUpSeller getSignUpSeller(ResultSet resultSet) {
		SignUpSeller signUpSeller = new SignUpSeller();
		try {
			signUpSeller.setiSellerID( resultSet.getInt("iSellerID") );
			signUpSeller.setsName(resultSet.getString("sName"));
			signUpSeller.setsEmail(resultSet.getString("sEmail"));
			signUpSeller.setsPassword(resultSet.getString("sPassword"));
			signUpSeller.setsPhoneNumber(resultSet.getString("sPhoneNumber"));
			signUpSeller.setsAddress(resultSet.getString("sAddress"));
			signUpSeller.setiRegistrationStatus(resultSet.getInt("iRegistrationStatus"));
			return signUpSeller;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return signUpSeller;
	}

	public static int update(String  selectionModifier) {

		String updateSQL = "update tSignUpSeller " + selectionModifier ;
		return DB.update(updateSQL);
	}

	
}

