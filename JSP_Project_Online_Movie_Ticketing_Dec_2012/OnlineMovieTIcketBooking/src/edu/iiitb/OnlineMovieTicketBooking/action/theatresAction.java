package edu.iiitb.OnlineMovieTicketBooking.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class theatresAction {
	
	static final String url = "jdbc:mysql://localhost:3306/jspproject";
	public static String getUrl() {
		return url;
	}


	
	public List selecttheatres(String city) {
		// TODO Auto-generated method stub
		List lstRegister = new ArrayList();
		
		ResultSet resultSet = null;
		List<String> list = new ArrayList<String>();
		try {
			 
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection(url, "root", "1234");
	        String query1 = "select sName from ttheater where sCity='" + city + "'";
	        
	        String query2 = "select iTheaterID from ttheater where sCity='" + city + "'";
	        Statement stmt = con.createStatement();
	        ResultSet result = stmt.executeQuery(query1);
	        System.out.println(result);
	        while(result.next())
	        {
	           list.add(result.getString("sName"));
	                          
	        } 
	        System.out.println(list);
	        
	        con.close();
	        

	    } catch (Exception ex) {
	       // Logger.getLogger(BooksWorker.class.getName()).log(
	                         //Level.SEVERE, null, ex);
	    	ex.printStackTrace();

	    }
		// TODO Auto-generated method stub
		return list;
	}



}
