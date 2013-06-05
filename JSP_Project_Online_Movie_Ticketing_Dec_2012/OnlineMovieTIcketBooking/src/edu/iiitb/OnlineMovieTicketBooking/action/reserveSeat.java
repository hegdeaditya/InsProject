package edu.iiitb.OnlineMovieTicketBooking.action;

import java.sql.Time;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.OnlineMovieTicketBooking.model.Dummy;
import edu.iiitb.OnlineMovieTicketBooking.service.reserveSeatService;

public class reserveSeat extends ActionSupport {

	//The following we will get from the session variables:
	
	private int iSubscriberID = 1;
	private String sCity = "Bangalore";
	private String sTheatre = "PVR";
	private String sMovie = "dabangg2";
	private String sClass = "Gold";
	//private Date dDate = '2013-01-03';
	//private Time tTime = '15:00:00';
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	/*
	private int iSubscriberID;
	private String sCity;
	private String sTheatre;
	private String sMovie;
	private String sClass;
	private Date dDate;
	private Time tTime;
	
	private String classType;
	
	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	private Dummy oDummy = new Dummy();
	
	public String execute(){
		
		
		reserveSeatService rss=new reserveSeatService();
		
		classType=rss.getClassFromDB(1);
		
		
		return SUCCESS;
	}
*/