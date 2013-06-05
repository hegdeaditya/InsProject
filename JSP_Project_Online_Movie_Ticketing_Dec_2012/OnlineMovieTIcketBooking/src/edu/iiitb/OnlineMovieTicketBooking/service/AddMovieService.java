package edu.iiitb.OnlineMovieTicketBooking.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;
import com.opensymphony.xwork2.ActionContext;

import edu.iiitb.OnlineMovieTicketBooking.model.Movies;
import edu.iiitb.OnlineMovieTicketBooking.model.SignUpSubscriber;

public class AddMovieService {
	
	public int addMovie(Movies movie){
		Map<String, Object> session=ActionContext.getContext().getSession();
		
		
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			java.sql.Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/jspproject?user=root&password=1234");
			java.sql.Statement statement = connection.createStatement();
			String sql="insert into tMovies("+"sName,"+ 
			"iRating,"+ 
			"dScreeningStartDate,"+ 
			"dScreeningEndDate,"+ 
			"tShowTiming1,"+
			"tShowTiming2,"+
			"tShowTiming3,"+
			"tShowTiming4,"+
			 "iTheaterID )"+ 
			"values("+"'"+movie.getsName()+"' ,"+movie.getiRating()+",'"+movie.getdScreeningStartDate()+"','"+movie.getdScreeningEndDate()+"','"+movie.gettShowTiming1()+"','"+movie.gettShowTiming2()+"','"+movie.gettShowTiming3()+"','"+movie.gettShowTiming4()+"',"+movie.getiTheatreID()+");";
			
			//System.out.println("name= "+movie.getsName()+"' ,"+movie.getiRating()+","+movie.getdScreeningStartDate()+","+movie.getdScreeningEndDate()+","+movie.gettShowTiming1()+","+movie.gettShowTiming2()+","+movie.gettShowTiming3()+","+movie.gettShowTiming4()+","+movie.getiTheatreID()+");");
			
			
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



}
