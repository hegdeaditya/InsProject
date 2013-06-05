package edu.iiitb.OnlineMovieTicketBooking.action;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;



import edu.iiitb.OnlineMovieTicketBooking.service.RegisterSubscriberDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegisterSubscriber extends ActionSupport{
	public int balance = 5000;
	
	static final String url = "jdbc:mysql://localhost:3306/jspproject";

	String subscribername,password,reenterpassword,email,address,age,phonenumber;


	public int getBalance() {
		return balance;
	}



	public void setBalance(int balance) {
		this.balance = balance;
	}



	public String getReenterpassword() {
		return reenterpassword;
	}



	public void setReenterpassword(String reenterpassword) {
		this.reenterpassword = reenterpassword;
	}



	public String getSubscribername() {
		return subscribername;
	}

	

	public void setSubscribername(String subscribername) {
		this.subscribername = subscribername;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAge() {
		return age;
	}



	public void setAge(String age) {
		this.age = age;
	}



	public String getPhonenumber() {
		return phonenumber;
	}



	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}



	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public static String getUrl() {
		return url;
	}

	
	
	public List getLstUsers() {
		return lstUsers;
	}
		
    private List lstUsers;

	public void setLstUsers(List lstUsers) {
		this.lstUsers = lstUsers;
	}

	  public String execute(){
		  		  
		  lstUsers=new RegisterSubscriberDao().verifyDetails(email);
		  
		  
			if(lstUsers.isEmpty()){
				
								
					if(subscribername.isEmpty()){
						addActionError("Fields cant be blank");
			    		return"error";
					}
					
					else if(password.isEmpty()){
						addActionError("Fields cant be blank");
			    		return"error";
					}
					
					
					
					else if(email.isEmpty()){
						addActionError("Fields cant be blank");
			    		return"error";
					}
					
					
					   
					
					  
					
					else if(phonenumber.isEmpty()){
						addActionError("Fields cant be blank");
			    		return"error";
					}
					
					else if(phonenumber.length()!= 10){
						addActionError("Phone number should be of length 10");
			    		return"error";
					}
					
					
					
					
					
					else if(address.isEmpty()){
						addActionError("Fields cant be blank");
			    		return"error";
					}
					
					/*else if(age.isEmpty()){
						addActionError("Fields cant be blank");
			    		return"error";
					}*/
					
					else if(! password.equals(reenterpassword)){
						addActionError("Enter same password in both password fields");
			    		return"error";
					}
					
					else{
						
							String  expression="^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
							 
							    Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);
							    Matcher matcher = pattern.matcher(email);
							
							if(! matcher.matches()){
								      System.out.println(email + " is an invalid email address.");
									      addActionError("Invalid email address");
								    		return"error";
							}
							else{
								try {
								 
						          String insert = "INSERT INTO tsignupsubscriber(sName,sEmail,sPassword,sPhoneNumber,sAddress,iBalance,iRegistrationStatus)" +
						                  "VALUES (?, ?, ?, ?, ?, ?, ?)";
						          
						          Class.forName("com.mysql.jdbc.Driver");
						          Connection con = DriverManager.getConnection(url, "root", "1234");
						 
						          PreparedStatement ps = con.prepareStatement(insert);

						          ps.setString(1,subscribername);
						          ps.setString(2,email);
						          ps.setString(3,password);
						          ps.setString(4,phonenumber);
						          ps.setString(5,address);
						          
						          ps.setInt(6,balance);
						          ps.setInt(7,1);
						          ps.executeUpdate();
						          con.close();
						          

						      } catch (Exception ex) {
						          ex.printStackTrace();
						      }
						      addActionError("Subscriber registered successfully. Login with your new credentials");
							return "success";
							}
							
							
						}
					}
							
					
							 
	    		
	    				
			else{
				addActionError("Email id already registered. Use any another Email id");
	    		return"error";
			}
		
			
		 	 
	  }
	  

	}
