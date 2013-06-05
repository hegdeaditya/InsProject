package edu.iiitb.OnlineMovieTicketBooking.action;

import java.sql.Date;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.OnlineMovieTicketBooking.service.testService;

public class testAction extends ActionSupport {

	//private String seatsLeftOfClassTypeSelected;
	//private int numberOfSeatsLeftOfClassTypeSelected;
	//private int numberOfSeatsLeft;
	//private Map<String, Object> session;
	
	//---GETTERS AND SETTERS---
	
	/*
	public String getSeatsLeftOfClassTypeSelected() {
		return seatsLeftOfClassTypeSelected;
	}

	public void setSeatsLeftOfClassTypeSelected(String seatsLeftOfClassTypeSelected) {
		this.seatsLeftOfClassTypeSelected = seatsLeftOfClassTypeSelected;
	}
	 
	public int getNumberOfSeatsLeftOfClassTypeSelected() {
		return numberOfSeatsLeftOfClassTypeSelected;
	}

	public void setNumberOfSeatsLeftOfClassTypeSelected(
			int numberOfSeatsLeftOfClassTypeSelected) {
		this.numberOfSeatsLeftOfClassTypeSelected = numberOfSeatsLeftOfClassTypeSelected;
	}

	public int getNumberOfSeatsLeft() {
		return numberOfSeatsLeft;
	}

	public void setNumberOfSeatsLeft(int numberOfSeatsLeft) {
		this.numberOfSeatsLeft = numberOfSeatsLeft;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	*/
	
	//---EXECUTE METHOD---
	public String execute() throws Exception {

		String seatsLeftOfClassTypeSelected;
		int classType;
		//Date dDate= new Date();
		//dDate.par13-01-03;
		
		//---INITIALIZE SESSION VARIABLES (RECEIVE FROM ABHILASH'S PART)---
		Map<String, Object> session = ActionContext.getContext().getSession();
		/*session.put("iSubscriberID", 1);
		session.put("sCity", "Bangalore");
		session.put("sTheatre", "PVR");
		session.put("sMovie", "Dabangg2");
		session.put("dDate", "2013-01-03");
		session.put("tTime", "15:00:00");
		
		//All above session variables can be replaced by session variables: iMovieTimingID, sClass
		session.put("iMovieTimingID", 3);
		session.put("sClass", "Silver");
		session.put("iSubscriberID", 1);*/
		
		//---PUT THE SEATS AVAILABLE IN THE SESSION VARIABLE CORRESPONDING TO THE USER'S SELECTION---
		
		
		
		
		
		//CREATE OBJECT OF RESPECTIVE SERVICE CLASS
		testService otestService = new testService();
		
		//CHECK WHICH CLASS TYPE USER WISHES
		if( session.get( "sClass" ) == "Gold" )
			classType = 1;
		else if ( session.get( "sClass" ) == "Silver" )
			classType = 2;
		else if ( session.get( "sClass" ) == "economy" )
			classType = 3;
		else 
			classType = 0;
		
		//GET THE AVAILABLE SEATS
		seatsLeftOfClassTypeSelected = otestService.getSeatsAvailable((Integer) session.get("iMovieTimingID"), classType);
		
		//CHECK IF SEATS ARE AVAILABLE OR NOT (SEATS LEFT COLUMN IS NOT NULL)
		if( seatsLeftOfClassTypeSelected != null ){
			
			//GET THE NUMBER OF SEATS AVAILABLE
			//GET THE TOTAL NUMBER OF SEATS AVAILABLE
			
			//PUT EVERYTHING IN SESSION VARIABLES
			session.put("seatsAvailable", seatsLeftOfClassTypeSelected);
			
			//---SEE THE SPLITTED STRING IN ARRAY FORM: (DONE IN reserveSeatAction.java)---
			//String columns[] = seatsLeftOfClassTypeSelected.split(";");
			//int i;
			
			//for( i = 0 ; i < columns.length ; i++){
			//	System.out.println(columns[i]);
			//}
			
			
			
			return "initialized";
		}
		else{
			return null;
		}
	}

}
