package edu.iiitb.OnlineMovieTicketBooking.action;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.OnlineMovieTicketBooking.model.SignUpSeller;
import edu.iiitb.OnlineMovieTicketBooking.model.SignUpSubscriber;

public class AdminActivateAndDeActivateLogic extends ActionSupport  {

	private int sellerID;
	private int subscriberID;
	private String usertype;
	
	
	
	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public int getSellerID() {
		return sellerID;
	}
	
	public void setSellerID(int sellerID) {
		this.sellerID = sellerID;
	}
	
	public int getSubscriberID() {
		return subscriberID;
	}
	
	public void setSubscriberID(int subscriberID) {
		this.subscriberID = subscriberID;
	}

	public String deactivateSeller(){


		int regStatus=-2;

		String selectionModifier="set iRegistrationStatus  = "+regStatus+" where iSellerID ="+this.getSellerID()+";";
		SignUpSeller.update(selectionModifier);
		this.usertype="Seller Deactivation successfull";
		addActionMessage(getText("Seller Deactivation successfull"));
		return "deactivateSellerSuccess";

	}

	public String activateSeller(){


		int regStatus=1;

		String selectionModifier="set iRegistrationStatus  = "+regStatus+" where iSellerID ="+this.getSellerID()+";";
		SignUpSeller.update(selectionModifier);
		this.usertype="Seller Activation successfull!!";
		addActionMessage(getText("Seller Activation successfull"));
		return "activateSellerSuccess";

	}

	public String deactivateSubscriber(){


		int regStatus=-2;
		System.out.println("getSubscriberID="+this.getSubscriberID());
		String selectionModifier="set iRegistrationStatus  = "+regStatus+" where iSubscriberID ="+this.getSubscriberID()+";";
		SignUpSubscriber.update(selectionModifier);
		this.usertype="Subscriber Deactivation Successfull!!";
		addActionMessage(getText("Subscriber Deactivation successfull"));
		return "deactivateSubscriberSuccess";

	}

	public String activateSubscriber(){
		int regStatus=1;
		System.out.println("getSubscriberID="+this.getSubscriberID());
		String selectionModifier="set iRegistrationStatus  = "+regStatus+" where iSubscriberID ="+this.getSubscriberID()+";";
		SignUpSubscriber.update(selectionModifier);
		this.usertype="Subscriber Activation Successfull!!";
		addActionMessage(getText("Subscriber Activation successfull"));
		return "activateSubscriberSuccess";

	}

}
