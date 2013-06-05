package edu.iiitb.OnlineMovieTicketBooking.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class citiesAction {
	
	static final String url = "jdbc:mysql://localhost:3306/jspproject";
	public static String getUrl() {
		return url;
	}


	public List lists() {
		List lstRegister = new ArrayList();
		
		ResultSet resultSet = null;
		List<String> list = new ArrayList<String>();
		try {
			 
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection(url, "root", "1234");
	        String query = "select distinct sCity from tTheater";
	        Statement stmt = con.createStatement();
	        ResultSet result = stmt.executeQuery(query);
	        System.out.println(result);
	        while(result.next())
	        {
	           list.add(result.getString("sCity"));
	                          
	        } 
	        System.out.println(list);
	        
	        con.close();
	        

	    } catch (Exception ex) {
	        //Logger.getLogger(BooksWorker.class.getName()).log(
	                         //Level.SEVERE, null, ex);
	    	ex.printStackTrace();
	    }
		// TODO Auto-generated method stub
		return list;
	}
	public static ArrayList<String> getCityNames() {
		
		
		ResultSet resultSet = null;
		ArrayList<String> nameList =null;// new ArrayList<String>();
		try {
			 
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection(url, "root", "1234");
	        String query = "select distinct sCity from tTheater";
	        Statement stmt = con.createStatement();
	        ResultSet result = stmt.executeQuery(query);
	        System.out.println(result);
	       if(result.next()){
	    	   nameList = new ArrayList<String>();
	    	   nameList.add(result.getString("sCity"));
	       }
	       else return nameList;
	        
	        while(result.next())
	        {
	        	nameList.add(result.getString("sCity"));
	                          
	        } 
	        System.out.println(nameList);
	        
	        con.close();
	        

	    } catch (Exception ex) {
	        //Logger.getLogger(BooksWorker.class.getName()).log(
	                         //Level.SEVERE, null, ex);
	    	ex.printStackTrace();
	    }
		// TODO Auto-generated method stub
		return nameList;
	}

}
