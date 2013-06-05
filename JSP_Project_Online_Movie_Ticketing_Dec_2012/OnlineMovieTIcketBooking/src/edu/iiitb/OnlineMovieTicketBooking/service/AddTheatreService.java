package edu.iiitb.OnlineMovieTicketBooking.service;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import edu.iiitb.OnlineMovieTicketBooking.model.Theatre;
import edu.iiitb.OnlineMovieTicketBooking.model.TheatreClassAndPrice;

public class AddTheatreService {
	
	public int addTheatre(Theatre theatre){
		Map<String, Object> session=ActionContext.getContext().getSession();
		int iSellerID=(Integer) session.get("iSellerID");
		if(iSellerID==0){
			System.out.println("In AddTheatreService:addTheatreMethod isellerID=0");
			return 0;
		}
		
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			java.sql.Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/jspproject?user=root&password=1234");
			java.sql.Statement statement = connection.createStatement();
			String sql="insert into tTheater("+"sName,"+ 
			"sPhoneNumber,"+ 
			"sAddress,"+ 
			"sCity,"+ 
			"sState,"+ 
			"iNumberOfSeates,"+ 
			"iSellerID)"+ 
			"values("+
			"'"+theatre.getsName()+"' ,"+
			"'"+theatre.getsPhoneNumber()+"' ,"+
			"'"+theatre.getsAddress()+"' ,"+
			"'"+theatre.getsCity()+"' ,"+
			"'"+theatre.getsState()+"',"+theatre.getiNumberOfSeates()+","+iSellerID+");";
			
			
			
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

public int addTheatreClassAndPrice(TheatreClassAndPrice theatreClassAndPricebean){
	
	ResultSet rs=null;
	try {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		java.sql.Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/jspproject?user=root&password=1234");
		java.sql.Statement statement = connection.createStatement();
		String sql="insert into tTheaterClassAndPrice("+"sClass,"+ 
		"iPrice,"+ 
		"iNumberOfSeatsPerClass,"+ 
		"iTheaterID)"+ 
		"values("+
		"'"+theatreClassAndPricebean.getsClass()+"' ,"+theatreClassAndPricebean.getiPrice()+","+theatreClassAndPricebean.getiNimberOfSeatsPerClass()+","+theatreClassAndPricebean.getiTheatreID()+");";
		
		
		
		int autoIncKeyFromApi = -1;
		statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
		rs=statement.getGeneratedKeys();
		if(rs.next()){
			autoIncKeyFromApi=rs.getInt(1);
		}else{
			throw new Exception("key not generated!");
		}
		rs.close();
//		System.out.println("id="+autoIncKeyFromApi);
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
}
