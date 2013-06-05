package edu.iiitb.OnlineMovieTicketBooking.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class moviesAction {
	
	
	static final String url = "jdbc:mysql://localhost:3306/jspproject";
	public static String getUrl() {
		return url;
	}


	

	public static List selectmovies(String theatre,String city) {
		// TODO Auto-generated method stub
		List lstRegister = new ArrayList();
		
		ResultSet resultSet = null;
		List<String> list =null;//new ArrayList<String>();
		try {
			 
			
			
//			try {
	    	SimpleDateFormat oSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");      
			java.util.Date dateWithoutTime = oSimpleDateFormat.parse(oSimpleDateFormat.format(new java.util.Date()));
			
			long dateConversion;
			dateConversion = dateWithoutTime.getTime();
			java.sql.Date dCurrentDate= new java.sql.Date(dateConversion);
			

			System.out.println(dCurrentDate);

	        Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection(url, "root", "1234");
	        System.out.println("name ="+theatre+"city"+city);
	        String query = "select distinct a.sName from tMovies a inner join tTheater b on a.iTheaterID=b.iTheaterID where b.sName='" + theatre + "' and b.sCity='" + city + "' and a.dScreeningEndDate >= '" + dCurrentDate + "' ";
	        Statement stmt = con.createStatement();
	        ResultSet result = stmt.executeQuery(query);
	       // System.out.println(result);
	        if(result.next()){
	        	
	        	list=new ArrayList<String>();
	        	list.add(result.getString("a.sName"));
	        }
	        while(result.next())
	        {
	           list.add(result.getString("a.sName"));
	                          
	        } 
	        System.out.println(list);
	        
	        con.close();
	        

	    } catch (Exception ex) {
	      // Logger.getLogger(BooksWorker.class.getName()).log(
	                        // Level.SEVERE, null, ex);
	    	ex.printStackTrace();
	    	return list;

	    }
		// TODO Auto-generated method stub
		return list;
	}

}
