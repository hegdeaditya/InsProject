package edu.iiitb.OnlineMovieTicketBooking.action;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.OnlineMovieTicketBooking.model.SignUpSeller;

public class ConformSellerAction extends ActionSupport   {
	
	private int sellerID;
	private SignUpSeller signUpSeller= new SignUpSeller();
	
	
	public int getSellerID() {
		return sellerID;
	}



	public void setSellerID(int sellerID) {
		this.sellerID = sellerID;
	}

	public String execute() throws Exception {
		int regStatus=1;
		
		String selectionModifier="set iRegistrationStatus  = "+regStatus+" where iSellerID ="+this.getSellerID()+";";
		SignUpSeller.update(selectionModifier);
		addActionMessage(getText("Registration Accepted!!"));
		return SUCCESS;
		
		
	}

}
