package edu.iiitb.OnlineMovieTicketBooking.model;

import java.util.ArrayList;

public class SignUpSeller {
//iSellerID ,sName ,sEmail ,sPassword,  sPhoneNumber, sAddress
	
	private int iSellerID;
	private String sName;
	private String sEmail;
	private String sPassword;
	private String sPhoneNumber;
	private String sAddress;
	private int iRegistrationStatus ;
	
	
	public static int update(String selectionModifier) {
		return SignUpSellerDAO.update(selectionModifier);
	}
	
	
	public int insert() {
		return SignUpSellerDAO.insert(this);
	}
	
	public static ArrayList<SignUpSeller> find(String selectionModifier){
		return SignUpSellerDAO.find(selectionModifier);
		
		
	}
	
	public int getiRegistrationStatus() {
		return iRegistrationStatus;
	}

	public void setiRegistrationStatus(int iRegistrationStatus) {
		this.iRegistrationStatus = iRegistrationStatus;
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
	public String getsEmail() {
		return sEmail;
	}
	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
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
