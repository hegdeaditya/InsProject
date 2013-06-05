package edu.iiitb.OnlineMovieTicketBooking.model;

import java.util.ArrayList;

import edu.iiitb.OnlineMovieTicketBooking.util.DB;

public class SellerRegistrationRequest {
	
	private int iSellerID ;
	private String sName ;
	private String sEmail ;
	private String sPassword ;
	private String sPhoneNumber ;
	private String sAddress ;
	
	public int insert() {
		return SellerRegistrationRequestDAO.insert(this);
		
	}

	public static ArrayList<SellerRegistrationRequest> find(String selectionModifier) {
		return SellerRegistrationRequestDAO.find(selectionModifier);
	}

	public static int DeleteOne(String selectionModifier) {
		return SellerRegistrationRequestDAO.DeleteOne(selectionModifier);
	}
	
	public String getsEmail() {
		return sEmail;
	}
	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}
	public int getiSellerID() {
		return iSellerID;
	}
	public void setiSellerID(int iSellerID) {
		this.iSellerID = iSellerID;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsPassword() {
		return sPassword;
	}
	public void setsPassword(String sPassword) {
		this.sPassword = sPassword;
	}
	public String getsPhoneNumber() {
		return sPhoneNumber;
	}
	public void setsPhoneNumber(String sPhoneNumber) {
		this.sPhoneNumber = sPhoneNumber;
	}
	public String getsAddress() {
		return sAddress;
	}
	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}

}
