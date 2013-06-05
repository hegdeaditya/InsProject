package edu.iiitb.OnlineMovieTicketBooking.service;

import java.sql.DriverManager;
import java.sql.ResultSet;

import edu.iiitb.OnlineMovieTicketBooking.model.Admin;
public class LoginService {
	
	
	public String AuthenticateUser(String sEmail ,String pass){
		
		
		int ret1,ret2,ret3;
		String str=null;
		
		ret1=getSignUpSellerID(sEmail, pass);
		ret2=getSignUpSubscriberID(sEmail, pass);
		ret3=getAdminid(sEmail, pass);
		
		if(ret1==0 && ret2==0 && ret3==0) return str;
		
		if(ret1!=0) return "seller";
		
		if(ret2!=0) return "subscriber";
		
		if(ret3!=0) return "admin";
		
		return str;
				
	}
	

public int getAdminid(String sEmail, String pass) {
	
	Admin admin_ret=null;
	String selectionModifier=" where sAdminEmail='"+sEmail+"' and sAdminPassword='"+pass+"'";
	admin_ret=Admin.findOne(selectionModifier);
	if(admin_ret==null)	return 0;
	
	else return admin_ret.getAdminID();
	}

public int getSignUpSellerID(String sEmail ,String pass){

	ResultSet rs=null;
	try {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		java.sql.Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/jspproject?user=root&password=1234");
		java.sql.Statement statement = connection.createStatement();
		String sql="select iSellerID from tSignUpSeller where sEmail= '"+sEmail+"' and  sPassword = '"+pass+"' ";
		
		rs=statement.executeQuery(sql);	
		if(rs.next()){
	        
			return rs.getInt(1);
			
		}else{
			
		}
		rs.close();

		if (statement != null) 
			statement.close();
		connection.close();
			
		
	} catch (Exception e) {
		System.out.println(" Exception occurred in LoginService.java	exception:Exception" + e);
		return 0;
	} 

	return 0;
	
}
public int getRegstatusidOfSeller(String sEmail ,String pass){

	ResultSet rs=null;
	try {
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		java.sql.Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/jspproject?user=root&password=1234");
		java.sql.Statement statement = connection.createStatement();
		String sql="select iRegistrationStatus  from tSignUpSeller where  sEmail= '"+sEmail+"' and  sPassword = '"+pass+"' ";
		
		rs=statement.executeQuery(sql);	
		if(rs.next()){
	        
			return rs.getInt(1);
			
		}else{
			
		}
		rs.close();

		if (statement != null) 
			statement.close();
		connection.close();
			
		
	} catch (Exception e) {
		System.out.println(" Exception occurred in LoginService.java	exception:Exception" + e);
		return 0;
	} 

	return 0;
	
}
public int getSignUpSubscriberID(String sEmail ,String pass){

	ResultSet rs=null;

	
	
	try {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		java.sql.Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/jspproject?user=root&password=1234");
		java.sql.Statement statement = connection.createStatement();
		String sql="select iSubscriberID   from  tSignUpSubscriber where sEmail  = '"+sEmail+"' and sPassword = '"+pass+"' ";
		
		rs=statement.executeQuery(sql);	
		if(rs.next()){
	        
			return rs.getInt(1);
			
			
			
		}else{
			
		}
		rs.close();

		if (statement != null) 
			statement.close();
		connection.close();
			
		
	} catch (Exception e) {
		System.out.println(" Exception occurred in LoginService.java	exception:Exception" + e);
		return 0;
	} 


	
	
	
	return 0;
	
}

public int getRegstatusidOfSubscriber(String sEmail ,String pass){

	ResultSet rs=null;

	
	
	try {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		java.sql.Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/jspproject?user=root&password=1234");
		java.sql.Statement statement = connection.createStatement();
		String sql="select iRegistrationStatus   from  tSignUpSubscriber where sEmail  = '"+sEmail+"' and sPassword = '"+pass+"' ";
		
		rs=statement.executeQuery(sql);	
		if(rs.next()){
	        
			return rs.getInt(1);
			
			
			
		}else{
			
		}
		rs.close();

		if (statement != null) 
			statement.close();
		connection.close();
			
		
	} catch (Exception e) {
		System.out.println(" Exception occurred in LoginService.java	exception:Exception" + e);
		return 0;
	} 


	
	
	
	return 0;
	
}

public String getSubscriberName(String sEmail, String pass) {
ResultSet rs=null;

	
	
	try {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		java.sql.Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/jspproject?user=root&password=1234");
		java.sql.Statement statement = connection.createStatement();
		String sql="select sName   from  tSignUpSubscriber where sEmail  = '"+sEmail+"' and sPassword = '"+pass+"' ";
		
		rs=statement.executeQuery(sql);	
		if(rs.next()){
	        
			return rs.getString(1);
			
			
			
		}else{
			
		}
		rs.close();

		if (statement != null) 
			statement.close();
		connection.close();
			
		
	} catch (Exception e) {
		System.out.println(" Exception occurred in LoginService.java	exception:Exception" + e);
		return null;
	}
	return null; 
}
	
}


