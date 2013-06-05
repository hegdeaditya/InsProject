package edu.iiitb.OnlineMovieTicketBooking.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.opensymphony.xwork2.ActionContext;

class datesAction {
	
	
	static final String url = "jdbc:mysql://localhost:3306/jspproject";
	public static String getUrl() {
		return url;
	}


	

	public List selectdates(String classy,String movie) {
		// TODO Auto-generated method stub
		List lstRegister = new ArrayList();
		
		ResultSet resultSet = null;
		List<String> list = new ArrayList<String>();
		try {
			 
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection(url, "root", "1234");
	        Map session = ActionContext.getContext().getSession();
	        int iMovieID=(Integer) session.get("iMovieID");
	        String query = "select distinct dDate from tmovietimings where iMovieID=" + iMovieID + " and (sclass1='" + classy + "' or sclass2='" + classy + "' or sclass3='" + classy + "') ";
	        System.out.println(query);
	        Statement stmt = con.createStatement();
	        ResultSet result = stmt.executeQuery(query);
	        System.out.println(result);
	        while(result.next())
	        {
	           list.add(result.getString("dDate"));
	                          
	        } 
	        System.out.println(list);
	        
	        con.close();
	        

	    } catch (Exception ex) {
	       // Logger.getLogger(BooksWorker.class.getName()).log(
	         //                Level.SEVERE, null, ex);
	    	ex.printStackTrace();

	    }
		// TODO Auto-generated method stub
		return list;
	}

}
