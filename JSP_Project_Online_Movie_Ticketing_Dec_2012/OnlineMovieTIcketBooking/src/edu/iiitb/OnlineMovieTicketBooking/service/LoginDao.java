package edu.iiitb.OnlineMovieTicketBooking.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginDao {
	static final String url = "jdbc:mysql://localhost:3306/jspproject";
	public static String getUrl() {
		return url;
	}
	public List verifyDetails(String username,String password){
	List lstRegister = new ArrayList();
	
	ResultSet resultSet = null;
	List<String> list = new ArrayList<String>();
	try {
		 
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, "root", "1234");
        String query = "select sname from tsignupsubscriber where sname='" + username + "' and spassword='" + password + "'";
        Statement stmt = con.createStatement();
        ResultSet result = stmt.executeQuery(query);
        System.out.println(result);
        while(result.next())
        {
           list.add(result.getString("sname"));
                          
        } 
        System.out.println(list);
        
        con.close();
        

    } catch (Exception ex) {
    	ex.printStackTrace();

    }
    
    
//	String query = "select ssubscribername from tsignupsubscriber where ssubscribername='" + username + "' and spassword='" + password + "'";
//	Connection connection = DB.getConnection();
//resultSet = DB.readFromDB(query, connection);
//	try {
//		while (resultSet.next()) {
//			String userName = resultSet.getString("ssubscribername");
//			String userid = resultSet.getString("user_id");
//			String f_name = resultSet.getString("fname");
//			LoginVo loginVo = new LoginVo(userName);
//			System.out.println(""+f_name);
			
//			Map session = ActionContext.getContext().getSession();
//			session.put("first_name",f_name);
//			session.put("uid",userid);
//			System.out.println("user id"+userid);
			
//			lstRegister.add(loginVo);
//		}
//	} catch (SQLException e) {
//        MyLog.myCatch("Register Dao", 43, e);
//		e.printStackTrace();
//	}finally{
	
//	DB.close(resultSet);
//	DB.close(connection);
//	}
    return list;
//	return lstRegister;
}
	public int fetchsubscrid(String username, String password) {
		

		List lstRegister = new ArrayList();
		int iSubscriberID=0;
		
		ResultSet resultSet = null;
		List<String> list = new ArrayList<String>();
		try {
			 
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection(url, "root", "1234");
	        String query = "select iSubscriberID from tsignupsubscriber where sname='" + username + "' and spassword='" + password + "'";
	        Statement stmt = con.createStatement();
	        ResultSet result = stmt.executeQuery(query);
	        System.out.println(result);
	        
	        while(result.next())
	        {
	        	iSubscriberID=result.getInt("iSubscriberID");
	                          
	        } 
	        System.out.println(list);
	        
	        con.close();
	        

	    } catch (Exception ex) {
	    	ex.printStackTrace();

	    }
	
	    return iSubscriberID;
		// TODO Auto-generated method stub
		
	}
}