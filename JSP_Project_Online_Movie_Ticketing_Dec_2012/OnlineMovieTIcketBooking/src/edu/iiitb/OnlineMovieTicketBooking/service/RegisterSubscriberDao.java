package edu.iiitb.OnlineMovieTicketBooking.service;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

import edu.iiitb.OnlineMovieTicketBooking.util.DB;
import edu.iiitb.OnlineMovieTicketBooking.util.MyLog;
import com.opensymphony.xwork2.ActionContext;


public class RegisterSubscriberDao {
	static final String url = "jdbc:mysql://localhost:3306/jspproject";
	public static String getUrl() {
		return url;
	}
	public List verifyDetails(String email){
	List lstRegister = new ArrayList();
	
	ResultSet resultSet = null;
	List<String> list = new ArrayList<String>();
	try {
		 
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, "root", "1234");
        String query = "select sEmail from tsignupsubscriber where sEmail='" + email + "'";
        Statement stmt = con.createStatement();
        ResultSet result = stmt.executeQuery(query);
        System.out.println(result);
        while(result.next())
        {
           list.add(result.getString("sEmail"));
                          
        } 
        System.out.println(list);
        
        con.close();
        

    } catch (Exception ex) {
        ex.printStackTrace();
    }
    
  
    return list;

}
}