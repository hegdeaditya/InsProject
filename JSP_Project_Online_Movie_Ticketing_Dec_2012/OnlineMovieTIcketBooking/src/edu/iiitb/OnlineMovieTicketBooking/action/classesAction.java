package edu.iiitb.OnlineMovieTicketBooking.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class classesAction {
	
	
	static final String url = "jdbc:mysql://localhost:3306/jspproject";
	public static String getUrl() {
		return url;
	}


	

	public List selectclass(String movie,int iTheaterID,int iMovieID) {
		// TODO Auto-generated method stub
		List lstRegister = new ArrayList();
		
		ResultSet resultSet = null;
		List<String> list = new ArrayList<String>();
		try {
			String demo="NULL";
			int ret=0;
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection(url, "root", "1234");
	        String query1 = "select distinct a.sClass1 " +
	        				" from tMovieTimings a, tMovies b, tTheater c " +
	        				" where  c.iTheaterID="+iTheaterID+" and  c.iTheaterID=b.iTheaterID and  " +
	        						"b.iMovieID="+iMovieID+" and a.iMovieID=b.iMovieID  " +
	        								"and a.iSeatsLeftType1 !="+ret ;
	       
	        String query2 = "select distinct a.sClass2 " +
    				" from tMovieTimings a, tMovies b, tTheater c " +
    				" where  c.iTheaterID="+iTheaterID+" and  c.iTheaterID=b.iTheaterID and  " +
    						"b.iMovieID="+iMovieID+" and a.iMovieID=b.iMovieID  " +
    								"and a.iSeatsLeftType2 !="+ret ;
	        
	        String query3 = "select distinct a.sClass3 " +
    				" from tMovieTimings a, tMovies b, tTheater c " +
    				" where  c.iTheaterID="+iTheaterID+" and  c.iTheaterID=b.iTheaterID and  " +
    						"b.iMovieID="+iMovieID+" and a.iMovieID=b.iMovieID  " +
    								"and a.iSeatsLeftType3 !="+ret ;
	        
	       // String query2 = "select distinct a.sClass2 from tmovietimings a inner join tMovies b on a.iMovieID=b.iMovieID where b.sName='" + movie + "' and a.sClass2 IS NOT NULL" ;
	        //String query3 = "select distinct a.sClass3 from tmovietimings a inner join tMovies b on a.iMovieID=b.iMovieID where b.sName='" + movie + "' and a.sClass3 IS NOT NULL" ;
	        Statement stmt = con.createStatement();
	        ResultSet result1 = stmt.executeQuery(query1);
	      
	      //  System.out.println(result1);
	       // System.out.println(result2);
	        //System.out.println(result3);
	        
	        while(result1.next())
	        {
	        	//System.out.println("result1.getString(\"a.sClass1\")="+result1.getString("a.sClass1"));
	           //if(!result1.getString("a.sClass1").isEmpty())
	        	String st="Gold";
	        	list.add(st);
	                          
	        } 
	        ResultSet result2 = stmt.executeQuery(query2);
	        
	        while(result2.next())
	        {
	        	String st1="Silver";
	        	list.add(st1);
	                          
	        } 
	        ResultSet result3 = stmt.executeQuery(query3);
	        while(result3.next())
	        {	String st2="Economy";
        	list.add(st2);
	                          
	        } 
	        System.out.println(list);
	        
	        con.close();
	        

	    } catch (Exception ex) {
	      //  Logger.getLogger(BooksWorker.class.getName()).log(
	                        // Level.SEVERE, null, ex);
	    	ex.printStackTrace();

	    }
		// TODO Auto-generated method stub
		return list;
	}

}
