package edu.iiitb.OnlineMovieTicketBooking.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.OnlineMovieTicketBooking.model.Movies;

public class DeleteMovieAction extends ActionSupport{
	
	private int theatreID;
	private int iMovieID;
	private int IDnew;
	
	
	
	
	
	

	public int getIDnew() {
		return IDnew;
	}

	public void setIDnew(int iDnew) {
		IDnew = iDnew;
	}

	public int getiMovieID() {
		return iMovieID;
	}

	public void setiMovieID(int iMovieID) {
		this.iMovieID = iMovieID;
	}

	public int getTheatreID() {
		return theatreID;
	}

	public void setTheatreID(int theatreID) {
		this.theatreID = theatreID;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String execute() throws Exception {
		
		String selectionModifier="  where iMovieID="+IDnew;
		
		Movies.DeleteOne(selectionModifier);
		
		
		return SUCCESS;
		
	}
	
	public String deleteMOvieWhenTheaterDeleted(){
		return null;
		
		
	}
	
	public String setSessionfortheatre(){
		Map<String, Object> session1 = ActionContext.getContext().getSession();
		
		session1.put("theatreID",theatreID);
		return "success";
		
		
	}
	

}
