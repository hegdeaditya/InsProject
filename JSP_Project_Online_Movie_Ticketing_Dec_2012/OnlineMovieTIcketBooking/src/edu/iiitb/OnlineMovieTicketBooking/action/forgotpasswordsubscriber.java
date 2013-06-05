package edu.iiitb.OnlineMovieTicketBooking.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.OnlineMovieTicketBooking.service.emailcheck;

public class forgotpasswordsubscriber extends ActionSupport{


	
	private String email;
	
	private ArrayList<String> theaters;
	private ArrayList<String> movies;
	
	private List lstemails;
	
	
	
	//EMAIL DECLARATION
	public String from = "onlinemovieticketing@gmail.com";
	public String password = "iiitb.org";
	public String to;
	public String subject = "Password Retrieval - Online Movie Ticketing";
	public String body;

	
	
	static Properties properties = new Properties();
	static
	{
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable","true");
		properties.put("mail.smtp.port", "465");
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	public String execute() {
	
	
		email = this.getEmail();
		lstemails=new emailcheck().mailcheck(email);
		
		if(email.isEmpty()){
			addActionError("Field cant be blank");
    		return"error";
		}
		if(lstemails.isEmpty()){
    		addActionError("Not a registered email id");
    		return"error";
    	}
		
		else{
			
			//SENDING PASSWORD RETRIEVED FROM THE DATABASE TO THE EMAIL ID RECEIVED IN TEXT BOX
			
			//RECEIEV FROM TEXTBOX
			to = email;
			
			//GET 'body' INFORMATION
			body = "Your requested password is:  :'"+lstemails+"'. Please login with your credentials. ";
			
		      try
		      {
		         Session sessionMail = Session.getDefaultInstance(properties,  
		            new javax.mail.Authenticator() {
		            protected PasswordAuthentication 
		            getPasswordAuthentication() {
		            return new 
		            PasswordAuthentication(from, password);
		            }});

		         Message message = new MimeMessage(sessionMail);
		         message.setFrom(new InternetAddress(from));
		         message.setRecipients(Message.RecipientType.TO, 
		            InternetAddress.parse(to));
		         message.setSubject(subject);
		         message.setText(body);
		         Transport.send(message);
		         addActionError("Password is sent to your registered email ID. Please login with your credentials... ");
		         return "success";
		      }
		      catch(Exception e)
		      {
		         e.printStackTrace();
		         addActionError("Some error occured please try again.. ");
		         return "error";
		      }
		     			
			
			
		}
	
	}

}