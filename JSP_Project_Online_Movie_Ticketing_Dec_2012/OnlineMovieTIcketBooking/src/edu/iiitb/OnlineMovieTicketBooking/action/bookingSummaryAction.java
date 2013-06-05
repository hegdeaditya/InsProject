package edu.iiitb.OnlineMovieTicketBooking.action;

import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.OnlineMovieTicketBooking.service.bookingSummaryService;

public class bookingSummaryAction extends ActionSupport {

	private String commandButton;
	private String seatstring;

	public String getSeatstring() {
		return seatstring;
	}

	public void setSeatstring(String seatstring) {
		this.seatstring = seatstring;
	}

	public String getCommandButton() {
		return commandButton;
	}

	public void setCommandButton(String commandButton) {
		this.commandButton = commandButton;
	}


	//--- EMAIL PURPOSE ---
	public String from = "onlinemovieticketing@gmail.com";
	public String password = "iiitb.org";
	public String to;
	public String subject = "Movie Ticket";
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





	public String execute() throws Exception {


		//NEED TO UPDATE:
		//0. GET THE SESION VARIABLES' VALUES
		//1. tMovieTimimngs: UPDATE SEATS LEFT OF THAT TYPE, NUMBER OF SEATS LEFT OF THAT TYPE
		//3. tSignUpSubscriber: UPDATE THE BALANCE LEFT IN THE SUBSCRIBER'S ACCOUNT
		//2. tTicket: INSERT INTO THIS TABLE CORRESPONDING TO THE COLUMNS
		//4. E-Mail the tickets to subscriber


		//---GET THE SESSION VARIABLES' VALUES---
		
		//System.out.println("The selected seats : "+seatstring);
		
		//String arr[]=seatstring.split(", ");
		
		//System.out.println("No of selected seats : "+arr.length);
		
		
		Map<String, Object> session = ActionContext.getContext().getSession();

		int updateTableTMovieTimingsStatus;
		int iStatusOfTableTTicketInsert;

		//GET THESE VALUES FROM SESSION VARIABLES
		int iMovieTimingID;

		//UPDATING VALUES
		int iupdateNumberOfSeatsLeftOfTypeSelected;
		int iupdateNumberOfTotalSeatsLeft;
		String supdateSeatsLeftOfTypeSelected;
		int classType;


		iupdateNumberOfTotalSeatsLeft = (Integer) session.get("iTotalSeatsLeft") - (Integer) session.get("iNumberOfSeatsSelected");
		iupdateNumberOfSeatsLeftOfTypeSelected = (Integer) session.get("iNumberOfSeatsLeftOfTypeSelected") - (Integer) session.get("iNumberOfSeatsSelected");
		supdateSeatsLeftOfTypeSelected = (String) session.get("newSeatsAvailable");

		if(session.get("sClass").toString().equalsIgnoreCase("Gold"))
			classType = 1;
		else if(session.get("sClass").toString().equalsIgnoreCase("Silver"))
			classType = 2;
		else if(session.get("sClass").toString().equalsIgnoreCase("Economy"))
			classType = 3;
		else
			classType = 0;


		iMovieTimingID = (Integer) session.get("iMovieTimingID");

		bookingSummaryService obookingSummaryService = new bookingSummaryService(); 


		//---1. UPDATE TABLE tMovieTimings---
		updateTableTMovieTimingsStatus = obookingSummaryService.updateTableTMovieTimings(iMovieTimingID, iupdateNumberOfTotalSeatsLeft, iupdateNumberOfSeatsLeftOfTypeSelected, supdateSeatsLeftOfTypeSelected, classType);

		if (updateTableTMovieTimingsStatus == 1){

			//SUCCESSFUL UPDATE IN tMovieTimings

			//---2. INSERT IN tTicket---

			int iAmountPaid;
			int iNumberOfTicketsBought;
			int iSubscriberID;	
			String sSeatSelected;
			String sClass;
			String sDate;
			String sTime;
			String sPaidStatus;
			
			java.sql.Date dDate;

			iAmountPaid = (Integer) session.get("totalAmount");
			iNumberOfTicketsBought = (Integer) session.get("iNumberOfSeatsSelected");
			iSubscriberID = (Integer) session.get("iSubscriberID");
			sSeatSelected = (String) session.get("seatsSelected");
			sClass = (String) session.get("sClass");
			sDate = (String) session.get("dDate");
			sTime = (String) session.get("tTime");
			sPaidStatus = "paid";
			
			dDate = java.sql.Date.valueOf(sDate);
			

			iStatusOfTableTTicketInsert = obookingSummaryService.insertIntoTableTTicket(iAmountPaid, iNumberOfTicketsBought, sSeatSelected, sClass, dDate, sTime, sPaidStatus, iSubscriberID, iMovieTimingID);

			if(iStatusOfTableTTicketInsert == 1){
				//SUCCESSFUL INSERT IN tTicket

				//3. UPDATE THE BALANCE IN tSignUpSubscriber

				int iStatusUpdateBalance;
				int iBalance;

				iBalance = (Integer) session.get("newBalance");

				iStatusUpdateBalance = obookingSummaryService.updateBalance((Integer) session.get("iSubscriberID"), iBalance);

				if(iStatusUpdateBalance == 1){

					//SUCCESSFUL UPDATE OF BALANCE IN tSignUpSubscriber

					//TODO: ---4. Mail the subscriber ---

					int iticketID;
					//String ticketDetails;
					String TicketDate;
					String TicketTime;
					String sMovieName;
					
					iticketID = obookingSummaryService.getTicketID();
					
					if ( (iticketID != -1) && (iticketID != -2) ){
						
						//GET TICKET DATE AND TICKET TIME
						//ticketDetails = obookingSummaryService.getTicketDetails(iticketID);
												
						//SPLIT HERE TO GET THE DATE AND TIME
						// -- MAY NOT BE NEEDED -- (COZ I M EXTRACTING DETAILS FROM SESSION VARIABLES NOW)
						
						TicketDate = (String) session.get("dDate");
						TicketTime = (String) session.get("tTime");
						
						sMovieName = (String) session.get("sMovie");
						
						//GET 'to' INFORMATION
						to = obookingSummaryService.getEmailOfSubscriber((Integer) session.get("iSubscriberID"));
						
						if(to != null){
							
							body = "Your Unique Ticket ID is:  '"+iticketID+"'. It is confirmed for the Movie: '"+sMovieName+"' on '"+sDate+"' at '"+sTime+"'";
							//GET 'body' INFORMATION
							
							String ret = "SUCCESS";
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
						      }
						      catch(Exception e)
						      {
						         ret = "ERROR";
						         e.printStackTrace();
								addActionError("Email was not sent due to network issues. Your ticket is confirmed. You can verify on the counter or toll free number: 1800-11-22-33. Please return to home page");
						  
						      }
						      return ret;
						}
						else
							return "HALFSUCCESS";
					}
					else
						return "HALFSUCCESS";
				}
				else
					return "HALFSUCCESS";
			}
			else
				return "HALFSUCCESS";
		}
		else
			return "FAILURE";
	}

}
