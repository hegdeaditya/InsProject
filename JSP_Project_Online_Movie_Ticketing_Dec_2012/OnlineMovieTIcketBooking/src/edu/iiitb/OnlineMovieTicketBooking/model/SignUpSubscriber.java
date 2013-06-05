package edu.iiitb.OnlineMovieTicketBooking.model;

import java.util.ArrayList;

public class SignUpSubscriber {

	private int iSubscriberID;
	private String sName;
	private String sEmail;
	private String sPassword;
	private String sPhoneNumber;
	private String sAddress;
	private java.sql.Date iDOB;
	private int iBalance;
	private int iRegistrationStatus ;
	
	

	public static int update(String selectionModifier) {
		return SignUpSubscriberDAO.update(selectionModifier);
	}
	
	public int insert() {
		return SignUpSubscriberDAO.insert(this);
	}
	
	public static ArrayList<SignUpSubscriber> find(String selectionModifier){
		return SignUpSubscriberDAO.find(selectionModifier);
	}
	
	
	public int getiRegistrationStatus() {
		return iRegistrationStatus;
	}

	public void setiRegistrationStatus(int iRegistrationStatus) {
		this.iRegistrationStatus = iRegistrationStatus;
	}

	public java.sql.Date getiDOB() {
		return iDOB;
	}

	public void setiDOB(java.sql.Date iDOB) {
		this.iDOB = iDOB;
	}
	
	public int getiBalance() {
		return iBalance;
	}

	public void setiBalance(int iBalance) {
		this.iBalance = iBalance;
	}


	
	public int getiSubscriberID() {
		return iSubscriberID;
	}
	public void setiSubscriberID(int iSubscriberID) {
		this.iSubscriberID = iSubscriberID;
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
